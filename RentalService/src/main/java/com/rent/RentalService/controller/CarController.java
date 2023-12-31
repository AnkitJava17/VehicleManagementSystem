package com.rent.RentalService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rent.RentalService.model.Car;
import com.rent.RentalService.service.CarService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("api/rentals")
public class CarController {
	
	@Autowired
	private CarService carService;

	ResponseEntity<?> responseEntity;

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars(){
		return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
	}
		
	@GetMapping("/cars/available")
	public List<Car> getAllAvailableCars() {
	    return carService.getAvailableCars();
	}

	@GetMapping("/cars/{carId}")
	public Car getCarById(@PathVariable long carId){
		return carService.getCarById(carId);
	}



//	@GetMapping("/cars/location/{location}")
//	public ResponseEntity<?> getCarByLocation(@PathVariable String location){
//    Car cObj=this.carService.getCarByLocation(location);
//    responseEntity=new ResponseEntity<>(cObj,HttpStatus.OK);
//		return responseEntity;
//	}

	@GetMapping("/cars/available/filter")
	public List<Car> getAllAvailableCarsByLocation(@RequestParam("location") String location) {
		return carService.getCarByLocation(location);
	}

	@PostMapping("/cars")
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		Car carAdded = carService.saveCar(car);
		return new ResponseEntity<Car>(carAdded, HttpStatus.CREATED);
	}

	@PutMapping("/cars/{carId}")
	public ResponseEntity<Car> updateCar(@RequestBody Car carUp, @PathVariable long carId){
		Car car = carService.updateCar(carUp, carId);
		return new ResponseEntity<Car>(car,HttpStatus.CREATED);
	}

	@DeleteMapping("/cars/{carId}")
	public ResponseEntity<?> deleteCar(@PathVariable long carId){
		carService.deleteCar(carId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
}
