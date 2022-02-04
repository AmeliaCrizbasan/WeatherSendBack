package com.example.weathersendback.service;

import com.example.weathersendback.DTO.WeatherDTO;
import com.example.weathersendback.DTO.WeatherRequest;

public interface WeatherService {
    WeatherDTO addWeather(WeatherRequest request);
}


