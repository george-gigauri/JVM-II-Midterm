package com.example.Giorgi_Gigauri_davaleba_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import static javax.ws.rs.HttpMethod.GET;

public class WeatherBotService {

    private static final String URL = "http://localhost:8080/Giorgi_Gigauri_davaleba_1_war_exploded/api/weather";

    public static String respond(String msg) {
        switch (msg.toLowerCase(Locale.ROOT)) {
            case "all":
                return getAll();
            case "":
                return "Sorry, I can not understand this... :(";
            default:
                return getCityWeather(msg);
        }
    }

    public static String getAll() {
        try {
            URL url = new URL(URL);
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
            URL url = new URL(URL + "/" + city);
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
}
