package pl.pnoga.zti.serwer.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.pnoga.zti.serwer.controller.json.StationList;
import pl.pnoga.zti.serwer.controller.json.WeatherMeasurementList;
import pl.pnoga.zti.serwer.model.entity.Station;
import pl.pnoga.zti.serwer.model.entity.WeatherMeasurement;
import pl.pnoga.zti.serwer.model.repository.StationRepository;
import pl.pnoga.zti.serwer.model.repository.WeatherMeasurementRepository;
import pl.pnoga.zti.serwer.service.json.WeatherMeasurementListJson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final static Logger LOGGER = Logger.getLogger(ScheduleService.class);

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private WeatherMeasurementRepository weatherMeasurementRepository;

    @Scheduled(fixedDelay = 1000 * 60 * 60)
    private void getDataForDatabase() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        StationList stations = restTemplate.getForObject("http://mech.fis.agh.edu.pl/meteo/rest/json/info/", StationList.class);
        stationRepository.save(stations);
        LOGGER.debug(String.format("Saved %d stations", stations.size()));
        for (Station station : stations)
            getMeasurments(station.getStation());
    }

    private void getMeasurments(String stationName) {
        LOGGER.debug(String.format("Getting measurments for station %s", stationName));
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.HOUR_OF_DAY, -1);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        WeatherMeasurementListJson weatherMeasurements;
        try {
            weatherMeasurements = restTemplate.getForObject("http://mech.fis.agh.edu.pl/meteo/rest/json/all/" + stationName + "/"
                    + new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()), WeatherMeasurementListJson.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage());
            weatherMeasurements = new WeatherMeasurementListJson();
        }
        for (WeatherMeasurement weatherMeasurement : getWeatherMeasurementsEntity(weatherMeasurements)) {
            try {
                weatherMeasurementRepository.save(weatherMeasurement);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }

        LOGGER.debug(String.format("Saved %d measurments for station %s", weatherMeasurements.size(), stationName));
    }

    public WeatherMeasurementList getWeatherMeasurementsEntity(WeatherMeasurementListJson weatherMeasurementJsons) {
        return weatherMeasurementJsons.stream().map(weatherMeasurementJson ->
                new WeatherMeasurement(weatherMeasurementJson.getTime(), stationRepository.findByStation(weatherMeasurementJson.getStation()), weatherMeasurementJson.getData())).collect(Collectors.toCollection(WeatherMeasurementList::new));
    }
}
