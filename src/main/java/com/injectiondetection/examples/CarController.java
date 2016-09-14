package com.injectiondetection.examples;

import com.injectiondetection.examples.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarController {

    @Autowired
    private CarService carService;

    public String result() {
        return "Yeah! " + carService.getCarName();
    }

}
