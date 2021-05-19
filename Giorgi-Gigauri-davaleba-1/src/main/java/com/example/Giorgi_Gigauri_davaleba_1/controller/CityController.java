package com.example.Giorgi_Gigauri_davaleba_1.controller;

import com.example.Giorgi_Gigauri_davaleba_1.util.Util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cities")
public class CityController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getAvailableCities() {
        return Util.cities;
    }
}
