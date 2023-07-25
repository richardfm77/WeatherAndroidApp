package mx.unam.ciencias.androidview.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {


    public CityWeather getRequest(String cityName){
        int statusCode = 0;
        CityWeather cityWeather = null;
        try {
            String url1 = "localhost:8080/weather/%s";
            String urlApikey = String.format(url1, cityName);
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

                String city = jsonObject.get("city").getAsString();
                String lon = jsonObject.get("latitude").getAsString();
                String lat = jsonObject.get("longitude").getAsString();
                String temp = jsonObject.get("temperature").getAsString();
                String humidity = jsonObject.get("humidity").getAsString();

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
}
