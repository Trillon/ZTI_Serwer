package pl.pnoga.zti.serwer.service.json;

import pl.pnoga.zti.serwer.model.entity.WeatherData;

public class WeatherMeasurementJson {

    private Long id;
    private String time;
    private String station;
    private WeatherData data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
