package com.developers.weatherappservice.services;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.repositories.Cache;
import com.developers.weatherappservice.repositories.RequestOpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Manges the services of a weather.
 * */
@Service
public class ServiceWeather {

    /**
     * Repository of request a weather.
     * */
    @Autowired
    RequestOpenWeather requestOpenWeather;

    /**
     * Cache repository of a weather.
     * */
    @Autowired
    Cache<String, CityWeather> cache;

    public CityWeather getWeather(String cityName) {

        String clearCityName = cityName.toLowerCase().trim().strip();

        if (cache.containsKey(clearCityName))
            return cache.get(cityName);

        CityWeather cityWeather = requestOpenWeather.getWeather(cityName);

        cache.put(clearCityName, cityWeather);

        return cityWeather;
    }
}
