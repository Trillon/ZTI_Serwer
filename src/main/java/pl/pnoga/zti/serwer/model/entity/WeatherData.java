package pl.pnoga.zti.serwer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private double pressure;
    @Column
    private double temperature;
    @Column
    private double dewPointTemperature;
    @Column
    private double moisture;
    @Column
    private double lastHourDrop;
    @Column
    private double showers;
    @Column
    private double windDirection;
    @Column
    private double windSpeed;
    @Column
    private double momentaryWindSpeed;

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getDewPointTemperature() {
        return dewPointTemperature;
    }

    public void setDewPointTemperature(double dewPointTemperature) {
        this.dewPointTemperature = dewPointTemperature;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getLastHourDrop() {
        return lastHourDrop;
    }

    public void setLastHourDrop(double lastHourDrop) {
        this.lastHourDrop = lastHourDrop;
    }

    public double getShowers() {
        return showers;
    }

    public void setShowers(double showers) {
        this.showers = showers;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getMomentaryWindSpeed() {
        return momentaryWindSpeed;
    }

    public void setMomentaryWindSpeed(double momentaryWindSpeed) {
        this.momentaryWindSpeed = momentaryWindSpeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
