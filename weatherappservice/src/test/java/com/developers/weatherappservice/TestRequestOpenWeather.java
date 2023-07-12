package com.developers.weatherappservice;

import com.developers.weatherappservice.models.CityWeather;
import com.developers.weatherappservice.repositories.RequestOpenWeather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRequestOpenWeather {

    private RequestOpenWeather requestOpenWeather;

    @Test
    void lectureApi() {
        requestOpenWeather = new RequestOpenWeather();
        String apikey = requestOpenWeather.getApikey();
        System.out.println(apikey);
        assertNotEquals("", apikey);
    }

    @Test
    void requestWeather() {
        requestOpenWeather = new RequestOpenWeather();
        CityWeather cityWeather = requestOpenWeather.getWeather("Mexico City");
        System.out.println(cityWeather.toString());
        int statusCode = requestOpenWeather.getStatusCode();
        assertEquals(200, statusCode);
    }

}
