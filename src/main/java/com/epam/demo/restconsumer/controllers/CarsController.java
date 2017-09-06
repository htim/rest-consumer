package com.epam.demo.restconsumer.controllers;

import com.epam.demo.restconsumer.domain.Car;
import com.epam.demo.restconsumer.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Timur_Khudiakov on 9/5/2017.
 */
@RestController
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/cars")
    public List<Car> getCarsByBrand(@RequestParam String brand) {
        return carsService.getCarsByBrand(brand);
    }

}
