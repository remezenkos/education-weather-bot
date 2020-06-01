package service;

public final class ApiConstants {
    public final static String CITY_REGEX = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
    public final static int OK_STATUS_CODE = 200;
    public final static int NOT_FOUND_STATUS_CODE = 404;
    public final static String GET_WEATHER_BY_CITY_URL = "https://api.weatherbit.io/v2.0/current?city=";
    public final static String API_KEY = "854cc50b24bd4675bc1c7b3eb667b044";
    public static final String API_KEY_PARAM = "&key=";

    private ApiConstants() {
    }
}
