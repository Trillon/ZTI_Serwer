package pl.pnoga.zti.serwer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

    @Id
    private String name;

    @Column
    private String station;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private double altitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public double getLati() {
        return latitude;
    }

    public void setLati(double latitude) {
        this.latitude = latitude;
    }

    public double getLongi() {
        return longitude;
    }

    public void setLongi(double longitude) {
        this.longitude = longitude;
    }

    public double getAlti() {
        return altitude;
    }

    public void setAlti(double altitude) {
        this.altitude = altitude;
    }
}
