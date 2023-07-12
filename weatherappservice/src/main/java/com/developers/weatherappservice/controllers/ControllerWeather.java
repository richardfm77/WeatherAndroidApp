package com.developers.weatherappservice.controllers;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.services.ServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Manges the urls.
 * */
@RestController
public class ControllerWeather {

    /**
     * Services of a weather.
     * */
    @Autowired
    private ServiceWeather serviceWeather;

    /**
     * Manges the url: weather/{cityName}.
     * @param cityName name of city.
     * @return Weather of city.
     * */
    @RequestMapping(value = "weather/{cityName}", method = RequestMethod.GET)
    public CityWeather getWeather(@PathVariable String cityName) {
        return serviceWeather.getWeather(cityName);
    }
}
