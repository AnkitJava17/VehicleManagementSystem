package com.share.controller;

import com.share.model.Car;
import com.share.model.RideShare;
import com.share.service.CarService;
import com.share.service.RideShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rides")
public class RideController {
    @Autowired
    private RideShareService rideShareService;

    @Autowired
    private CarService carService;

    @PostMapping()
    public ResponseEntity<RideShare> bookRide(@RequestBody RideShare rideShare) {
        RideShare savedRideShare = rideShareService.insertRideRecord(rideShare);
        List<Car> savedCars = new ArrayList<>();
        for (Car car : rideShare.getCars()) {
            car.setRideId(savedRideShare.getRide_ID());
            Car savedCar = carService.saveCar(car);
            savedCars.add(savedCar);
        }
        savedRideShare.setCars(savedCars);

        return new ResponseEntity<>(savedRideShare, HttpStatus.CREATED);
    }

    // add cars for specific rides
    @PostMapping("/{ride_ID}/car")
    public ResponseEntity<Car> addCar(@PathVariable int ride_ID, @RequestBody Car car) {
        Optional<RideShare> ride = rideShareService.findById(ride_ID);
        if (ride.isPresent()) {
            RideShare rideShare = ride.get();
            car.setRideId(ride_ID);
            Car car1 = carService.saveCar(car);
            rideShare.getCars().add(car1);
            rideShareService.insertRideRecord(rideShare);
            return ResponseEntity.ok(car1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{ride_ID}/car")
    public ResponseEntity<List<Car>> getCarsByBookingId(@PathVariable int ride_ID) {
        Optional<RideShare> ride = rideShareService.findById(ride_ID);
        if (ride.isPresent()) {
            List<Car> cars = ride.get().getCars();
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public List<RideShare> getAllRideSharesWithCars() {
        List<RideShare> rideShares = rideShareService.getBookingDetails();
        for (RideShare rideShare : rideShares) {
            List<Car> cars = carService.getCarsByRideShareId(rideShare.getRide_ID());
            rideShare.setCars(cars);
        }
        return rideShares;
    }

    // Fetch all ride Details
    @GetMapping("/bookingDetails")
    public ResponseEntity<List<RideShare>> getBookingDetails() {
        List<RideShare> rideDetails = rideShareService.getBookingDetails();
        return ResponseEntity.ok(rideDetails);
    }

}
