package com.epam.demo.restconsumer.service;

import com.epam.demo.restconsumer.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Timur_Khudiakov on 9/5/2017.
 */
@Service
public class CarsService {

    private RestTemplate restTemplate;

    private String baseUrl = "http://localhost:9999";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Car> getCarsByBrand(String brand) {
        Car[] cars = restTemplate.getForObject(baseUrl + "/cars?brand={brand}", Car[].class, brand);
        return Arrays.asList(cars);
    }

}
