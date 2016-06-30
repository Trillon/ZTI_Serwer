package pl.pnoga.zti.serwer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pnoga.zti.serwer.controller.json.WeatherMeasurementList;
import pl.pnoga.zti.serwer.model.entity.Station;
import pl.pnoga.zti.serwer.service.MeasurmentService;
import pl.pnoga.zti.serwer.service.StationService;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private StationService stationService;

    @Autowired
    private MeasurmentService measurmentService;

    @RequestMapping("/stations")
    public List<Station> getStations() {
        return stationService.getStations();
    }

    @RequestMapping("/measurments/{date}")
    public WeatherMeasurementList getMeasurements(@PathVariable long date) {
        return measurmentService.getMeasurmentsSinceDate(date);
    }

}
