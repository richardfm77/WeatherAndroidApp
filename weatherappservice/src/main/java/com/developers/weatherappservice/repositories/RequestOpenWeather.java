package com.developers.weatherappservice.repositories;

import com.developers.weatherappservice.models.CityWeather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class serving as a weather repository.
 * It makes requests to the OpenWeather API.
 */
@Repository
public class RequestOpenWeather {

    /**
     * API key of Open weather.
     */
    private String apikey;

    /**
     * Request Status code.
     * */
    private int statusCode;

    /**
     * Build a @class{{@link RequestOpenWeather}}.
     * Read and set apikey.
     * */
    public RequestOpenWeather() {
        lectureApiKey();
    }

    /**
     * Makes lecture of apikey in
     * the file application.properties.
     * */
    private void lectureApiKey() {
        try {
            String PATH_FILE = "src/main/resources/application.properties";
            FileInputStream fileIn = new FileInputStream(PATH_FILE);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
            String line = in.readLine();
            apikey = line.split(" ")[1];
            in.close();
        } catch (IOException | ArrayIndexOutOfBoundsException ioe) {
            String ERROR_LECTURE = "Error reading API key";
            error(ERROR_LECTURE);
        }
    }

    /**
     * Makes a request of a city weather.
     * @param cityName name of city for request.
     * @return @class {@link CityWeather}.
     * */
    @SuppressWarnings("deprecation")
    public CityWeather getWeather(String cityName) {
        CityWeather cityWeather = null;
        try {
            String url1 = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
            String urlApikey = String.format(url1, cityName, apikey);
            URL url = new URL(urlApikey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            statusCode = connection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                String responseData = response.toString();

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(responseData, JsonObject.class);

                String city = jsonObject.get("name").getAsString();
                String lon = jsonObject.getAsJsonObject("coord").get("lon").getAsString();
                String lat = jsonObject.getAsJsonObject("coord").get("lat").getAsString();
                String temp = jsonObject.getAsJsonObject("main").get("temp").getAsString();
                String humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsString();

                cityWeather = new CityWeather(city, lat, lon, temp, humidity);

            } else if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                String ERROR_HTTP_NOT_FOUND = "Error city not found";
                throw new RuntimeException(ERROR_HTTP_NOT_FOUND);
            } else {
                String ERROR_REQUEST = "Error request";
                System.err.println(ERROR_REQUEST);
            }

        } catch (IOException io) {
            String ERROR_REQUEST = "Error request";
            System.err.println(ERROR_REQUEST);
        }

       return cityWeather;
    }

    /**
     * Shows message lecture error
     * and ending the server with status 1.
     */
    private void error(String message) {
        System.err.println(message);
        System.exit(1);
    }

    /**
     * Get apikey.
     * @return apikey.
     * */
    public String getApikey() {
        return this.apikey;
    }

    /**
     * Get status code.
     * @return status code.
     * */
    public int getStatusCode() {
        return this.statusCode;
    }

}
