package com.share.controller;

import com.share.model.Car;
import com.share.model.RideShare;
import com.share.service.CarService;
import com.share.service.RideShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:4200" )
@RestController
@RequestMapping("/api/rides")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private RideShareService rideShareService;
    //Fetch all car Details
    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/available")
    public List<Car> getAllAvailableCars() {
        return carService.getAvailableCars();
    }

    @GetMapping("/cars/available/filter")
    public List<Car> getAllAvailableCarsByDestAndSeats(@RequestParam("destination") String destination,
                                                       @RequestParam("passengers") int passengers) {
        return carService.getAvailableCarsByDateAndPassengers(destination, passengers);
    }


    //Fetch car Details by carId
    @GetMapping("/{carId}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable int carId) {
        Optional<Car> car = carService.getCarById(carId);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }


    @PostMapping("/{ride_ID}/addCars")
    public ResponseEntity<Car> saveCar(@RequestBody Car car , @RequestParam int ride_ID) {
        RideShare rideShare=rideShareService.findById(ride_ID).orElseThrow(()->new RuntimeException("Ride not found"));
        car.setRideShare(rideShare);
        rideShare.getCars().add(car);
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }



    //Delete Car details by car id
    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable int carId) {
        carService.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }

}
