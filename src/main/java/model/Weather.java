package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class Weather {
    private String city_name;
    private String country_code;
    private double temp;
    private String clouds;
    private String wind_cdir_full;


}
