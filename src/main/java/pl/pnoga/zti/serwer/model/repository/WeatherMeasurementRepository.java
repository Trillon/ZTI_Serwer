package pl.pnoga.zti.serwer.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pnoga.zti.serwer.controller.json.WeatherMeasurementList;
import pl.pnoga.zti.serwer.model.entity.WeatherMeasurement;

public interface WeatherMeasurementRepository extends JpaRepository<WeatherMeasurement, Long> {

    WeatherMeasurementList findByTimeAfter(long time);
}
