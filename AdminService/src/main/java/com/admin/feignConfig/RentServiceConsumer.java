package com.admin.feignConfig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.admin.model.RentBike;
import com.admin.model.RentCar;
import com.admin.model.RentVehicleInfo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="rental-service", url = "http://localhost:8082/api")
public interface RentServiceConsumer {
    
    @GetMapping("/rentals/bikes")
    public List<RentBike> getAllBikes();

    @PostMapping("/rentals/bikes")
    public RentBike addBike(@RequestBody RentBike bike);

    @GetMapping("/rentals/cars")
    public List<RentCar> getAllCars();

    @PostMapping("/rentals/cars")
    public RentCar addCar(@RequestBody RentCar car);

    @GetMapping("rentals/rentDetails")
    public List<RentVehicleInfo> getRentDetails();

    @PostMapping("/rentals/info")
    public RentVehicleInfo addInfo(@RequestBody RentVehicleInfo info);

}
