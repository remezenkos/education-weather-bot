package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Weather {
    private String city_name;
    private String timezone;
    private String country_code;
    private double temp;
    private String clouds;
    private double pres;
    private String wind_cdir_full;
    private String station;







}
