package mx.unam.ciencias.androidview.model;

/**
 * Class representing the weather of a city.
 * */
public class CityWeather {

    /**
     *  City name.
     * */
    private String city;

    /**
     *  Latitude of city.
     * */
    private String latitude;

    /**
     *  Longitude of city.
     * */
    private String longitude;

    /**
     * Temperature of weather.
     * */
    private String temperature;

    /**
     * Temperature of humidity.
     * */
    private String humidity;

    /**
     * Builds a @class{{@link CityWeather}}.
     * @param city name of city.
     * @param latitude latitude of city.
     * @param longitude longitude of city.
     * @param temperature temperature of city.
     * @param humidity humidity of city.
     * */
    public CityWeather(String city, String latitude, String longitude, String temperature, String humidity) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    /**
     * Get the name of city.
     * @return name of city.
     * */
    public String getCity() {
        return city;
    }

    /**
     * Set the name of city.
     * @param city name of city.
     * */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the latitude of city.
     * @return latitude of city.
     * */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Set the latitude of city.
     * @param latitude latitude of city.
     * */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Get the longitude of city.
     * @return longitude of city.
     * */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Set the longitude of city.
     * @param longitude longitude of city.
     * */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the temperature of weather.
     * @return temperature of weather.
     * */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Set the temperature of weather.
     * @param temperature temperature of city.
     * */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * Get the humidity of weather.
     * @return humidity of weather.
     * */
    public String getHumidity() {
        return humidity;
    }

    /**
     * Set the humidity of weather.
     * @param humidity humidity of city.
     * */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return String.format("{'CityName': '%s', 'lat': '%s', 'lon': '%s', 'temp': '%s', 'humidity': '%s'}",
                this.city, this.latitude, this.longitude, this.temperature, this.humidity);
    }



}
