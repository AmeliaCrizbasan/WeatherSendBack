package com.example.weathersendback.service;

import com.example.weathersendback.DTO.WeatherDTO;
import com.example.weathersendback.DTO.WeatherRequest;
import com.example.weathersendback.WeatherSendBackApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherSendBackApplication.MyGateway gateway;

    @SneakyThrows
    public WeatherDTO addWeather(WeatherRequest request) {
        WeatherDTO weather = new WeatherDTO();

        weather.setCity(request.getCity());
        weather.setTemp(request.getTemp());
        weather.setTempMin(request.getTempMin());
        weather.setTempMax(request.getTempMax());


        ObjectMapper objectMapper = new ObjectMapper();

        JSONObject obj=new JSONObject();
        obj.put("city",weather.getCity());
        obj.put("temp",weather.getTemp());
        obj.put("tempMin",weather.getTempMin());
        obj.put("tempMax",weather.getTempMax());
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // String w= objectMapper.writeValue(obj);
       String w = objectMapper.writeValueAsString(weather);

       // gateway.sendToMqtt(obj.toString());
       gateway.sendToMqtt(w);
        return weather;

    }
}
