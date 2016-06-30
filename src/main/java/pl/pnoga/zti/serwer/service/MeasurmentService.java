package pl.pnoga.zti.serwer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pnoga.zti.serwer.controller.json.WeatherMeasurementList;
import pl.pnoga.zti.serwer.model.repository.WeatherMeasurementRepository;

@Service
public class MeasurmentService {

    @Autowired
    WeatherMeasurementRepository weatherMeasurementRepository;

    public WeatherMeasurementList getMeasurmentsSinceDate(long date) {
        return weatherMeasurementRepository.findByTimeAfter(date);
    }
}
