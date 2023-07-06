package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.feignConfig.RentServiceConsumer;
import com.admin.model.RentBike;
import com.admin.model.RentCar;
import com.admin.model.RentVehicleInfo;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class RentalFeignController {

    @Autowired
    private RentServiceConsumer rentServiceConsumer;

    @GetMapping("/rental/bikes")
	public List<RentBike> getAllBikes()
	{
		return rentServiceConsumer.getAllBikes();
	}
	
	@GetMapping("/rental/cars")
	public List<RentCar> getAllCars()
	{
		return rentServiceConsumer.getAllCars();
	}

    @GetMapping("/info")
	public List<RentVehicleInfo> getRentDetails()
	{
		return rentServiceConsumer.getRentDetails();
	}

	@PostMapping("/rental/bikes")
	public RentBike addBike(@RequestBody RentBike bike)
	{
		return rentServiceConsumer.addBike(bike);
	}
	
	@PostMapping("/rental/cars")
	public RentCar addCar(@RequestBody RentCar car)
	{
		return rentServiceConsumer.addCar(car);
	}

	@PostMapping("/rental/info")
	public RentVehicleInfo addInfo(@RequestBody RentVehicleInfo info)
	{
		return rentServiceConsumer.addInfo(info);
	}
}
