package pl.pnoga.zti.serwer.model.entity;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"time", "station_name"})})
public class WeatherMeasurement {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String time;
    @ManyToOne
    private Station station;
    @OneToOne(cascade = CascadeType.ALL)
    private WeatherData data;

    public WeatherMeasurement() {
    }

    public WeatherMeasurement(String time, Station station, WeatherData data) {
        this.time = time;
        this.station = station;
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
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
