package com.share.controller;

import com.share.model.Car;
import com.share.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rides")
public class CarController {
    @Autowired
    private CarService carService;


    // Fetch all car Details
    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    //Fetch available cars 
    @GetMapping("/cars/available")
    public List<Car> getAllAvailableCars() {
        return carService.getAvailableCars();
    }


    //Get Cars based on destination and passengers
    @GetMapping("/cars/available/filter")
    public List<Car> getAllAvailableCarsByDestAndSeats(@RequestParam("destination") String destination,
            @RequestParam("passengers") int passengers) {
        return carService.getAvailableCarsByDateAndPassengers(destination, passengers);
    }

    // Fetch car Details by carId
    @GetMapping("/{carId}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable int carId) {
        Optional<Car> car = carService.getCarById(carId);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    // Delete Car details by car id
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable int carId) {
        carService.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }

}
