package com.epam.demo.restconsumer;

import com.epam.demo.restconsumer.domain.Car;
import com.epam.demo.restconsumer.service.CarsService;
import com.sun.javaws.exceptions.ExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class RestConsumerApplication implements CommandLineRunner {

    @Autowired
    private CarsService carsService;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Started...");
        String input = "";
        while (!Objects.equals(input, "q")) {
            System.out.println("Print brand to consume or 'q' to exit:");
            input = scanner.next();
            List<Car> carsByBrand = carsService.getCarsByBrand(input);
            carsByBrand.forEach(System.out::println);
        }
        SpringApplication.exit(applicationContext, () -> 0);
    }
}
