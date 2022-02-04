package com.example.weathersendback.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRequest {

    private String city;
    private Double temp;
    private Double tempMin;
    private Double tempMax;
}
