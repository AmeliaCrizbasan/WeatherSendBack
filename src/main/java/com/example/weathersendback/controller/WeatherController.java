package com.example.weathersendback.controller;

import com.example.weathersendback.DTO.WeatherDTO;
import com.example.weathersendback.DTO.WeatherRequest;
import com.example.weathersendback.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/weather")
public class WeatherController {
    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<WeatherDTO> addWeather(@RequestBody WeatherRequest request) {
        WeatherDTO response = weatherService.addWeather(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
