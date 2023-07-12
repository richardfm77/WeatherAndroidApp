package com.developers.weatherappservice.services;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.repositories.RequestOpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Manges the services of a weather.
 * */
@Service
public class ServiceWeather {

    /**
     * Repository of a weather.
     * */
    @Autowired
    RequestOpenWeather requestOpenWeather;
    public CityWeather getWeather(String cityName) {
        return requestOpenWeather.getWeather(cityName);
    }
}
