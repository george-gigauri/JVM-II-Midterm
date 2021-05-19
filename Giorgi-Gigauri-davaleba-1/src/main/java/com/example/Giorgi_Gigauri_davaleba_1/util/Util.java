package com.example.Giorgi_Gigauri_davaleba_1.util;

import com.example.Giorgi_Gigauri_davaleba_1.enums.WindDirectionType;
import com.example.Giorgi_Gigauri_davaleba_1.model.Weather;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static String[] cities = {
            "Tbilisi",
            "Batumi",
            "Khashuri",
            "Gori",
            "Rustavi",
            "Kutaisi",
            "Kobuleti",
            "Telavi",
            "Kvareli",
            "Ambrolauri",
            "Akhaltsikhe",
            "Borjomi",
            "Bakuriani",
            "Likani",
            "Mestia",
            "Zestaphoni",
            "Zugdidi",
            "Chiatura",
            "Samtredia",
            "Senaki"
    };

    public static List<Weather> generateRandomizedWeatherList(int size) {
        List<Weather> weatherList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            weatherList.add(generateWeatherModel());
        }

        return weatherList.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Weather::getCityName))),
                        ArrayList::new));
    }

    public static Weather generateWeatherModel() {
        Weather weather = new Weather();
        weather.setCityName(getRandomCity());
        weather.setTemperature(getRandomTemperature());
        weather.setWindDirection(getRandomWindDirection());
        weather.setHumidity(getRandomHumidity());
        weather.setPressure(getRandomPressure());
        weather.setWindSpeed(getRandomWindSpeed());
        return weather;
    }

    public static Weather generateWeatherModel(String city) {
        Weather weather = new Weather();
        weather.setCityName(city);
        weather.setTemperature(getRandomTemperature());
        weather.setWindDirection(getRandomWindDirection());
        weather.setHumidity(getRandomHumidity());
        weather.setPressure(getRandomPressure());
        weather.setWindSpeed(getRandomWindSpeed());
        return weather;
    }

    public static String getRandomCity() {
        Random random = new Random();
        int size = cities.length;
        int randomIndex = random.nextInt(size);
        return cities[randomIndex];
    }

    public static int getRandomTemperature() {
        return new Random().nextInt(45);
    }

    public static int getRandomHumidity() {
        return new Random().nextInt(100);
    }

    public static int getRandomWindSpeed() {
        return new Random().nextInt(50);
    }

    public static int getRandomPressure() {
        return new Random().nextInt(150);
    }

    public static WindDirectionType getRandomWindDirection() {
        Random random = new Random();
        WindDirectionType[] windDirectionTypes = WindDirectionType.values();
        int size = windDirectionTypes.length;
        int randomIndex = random.nextInt(size);
        return windDirectionTypes[randomIndex];
    }
}
