package com.developers.weatherappservice;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.repositories.Cache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCache {

    @Test
    void funtionCache() {
        try {
            Cache<String, CityWeather> cache = new Cache<>();
            cache.put("Mexico", new CityWeather("Mexico","10", "10", "20", "10"));
            cache.put("Canada", new CityWeather("Canada","10", "10", "20", "10"));
            cache.put("USA", new CityWeather("USA","10", "10", "20", "10"));
            cache.put("Brazil", new CityWeather("Brazil","10", "10", "20", "10"));

            System.out.println(cache);

            assertFalse(cache.isEmpty());

            Thread.sleep(1800000);

            assertTrue(cache.isEmpty());

            cache.setActive(false);

        } catch (InterruptedException in) {
            fail();
        }
    }
}
