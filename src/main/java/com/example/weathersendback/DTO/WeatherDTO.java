package com.example.weathersendback.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherDTO {
    //private Integer id;
    private String city;
    private Double temp;
    private Double tempMin;
    private Double tempMax;
}
