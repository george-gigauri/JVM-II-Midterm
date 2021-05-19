package com.example.Giorgi_Gigauri_davaleba_1.controller;

import com.example.Giorgi_Gigauri_davaleba_1.model.Weather;
import com.example.Giorgi_Gigauri_davaleba_1.util.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weather")
public class WeatherController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getAllWeathers() {
        return Util.generateRandomizedWeatherList(5);
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeather(@PathParam("city") String city) {
        return Util.generateWeatherModel(city);
    }
}
