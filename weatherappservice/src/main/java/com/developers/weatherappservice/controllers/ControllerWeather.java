package com.developers.weatherappservice.controllers;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.services.ServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleCustomException(RuntimeException runtimeException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getMessage());
    }

}
