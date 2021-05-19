package com.example.Giorgi_Gigauri_davaleba_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.HttpMethod.GET;

public class WeatherBotService {

    private static final String BASE_URL = "http://localhost:8080/Giorgi_Gigauri_davaleba_1_war_exploded/api/";

    private static final List<String> cities = getAllCities();

    public static String respond(String msg) {
        System.out.println(msg);
        String city = msg.toLowerCase();

        if (city.equals("all")) {
            return getAll()+ "\n";
        }

        if (cityExists(city)) {
            return getCityWeather(msg) + "\n\n";
        }

        return "\nSorry, Entered city can not be found. Please see available cities here: " +
                cities + "\n\n";
    }

    public static List<String> getAllCities() {
        try {
            URL url = new URL(BASE_URL + "cities");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(GET);
            httpURLConnection.setRequestProperty("Accept", "application/json");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output;
            List<String> result = new ArrayList<>();
            while ((output = bufferedReader.readLine()) != null) {
                result = Arrays.asList(output.replace("[", "").replace("]", "").replace("\"", "").split(","));
            }
            httpURLConnection.disconnect();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static String getAll() {
        try {
            URL url = new URL(BASE_URL + "weather");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(GET);
            httpURLConnection.setRequestProperty("Accept", "application/json");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output;
            StringBuilder result = new StringBuilder();
            while ((output = bufferedReader.readLine()) != null) {
                result.append(output);
            }
            httpURLConnection.disconnect();
            return result.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String getCityWeather(String city) {
        try {
            URL url = new URL(BASE_URL + "weather/" + city);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(GET);
            httpURLConnection.setRequestProperty("Accept", "application/json");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String output;
            StringBuilder result = new StringBuilder();
            while ((output = bufferedReader.readLine()) != null) {
                result.append(output);
            }
            httpURLConnection.disconnect();
            return result.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static boolean cityExists(String city) {
        for (String i : cities) {
            if (i.toLowerCase().equals(city)) {
                return true;
            }
            System.out.println(i.toLowerCase());
        }

        return false;
    }
}
