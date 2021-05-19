package com.example.Giorgi_Gigauri_davaleba_1.model;


import com.example.Giorgi_Gigauri_davaleba_1.enums.WindDirectionType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weather {
    private String cityName;
    private int temperature;
    private int windSpeed;
    private WindDirectionType windDirection;
    private int pressure;
    private int humidity;

    public Weather(String cityName, int temperature, int windSpeed, WindDirectionType windDirection, int pressure, int humidity) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Weather() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WindDirectionType getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirectionType windDirection) {
        this.windDirection = windDirection;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
