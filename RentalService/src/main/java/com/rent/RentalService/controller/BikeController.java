package com.rent.RentalService.controller;

import java.util.List;

import com.rent.RentalService.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rent.RentalService.model.Bike;
import com.rent.RentalService.service.BikeServiceImpl;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/rentals")
public class BikeController {
							
		@Autowired
		private BikeServiceImpl bikeService;
		
		@GetMapping("/bikes")
		public ResponseEntity<List<Bike>> getAllBikes(){
			return new ResponseEntity<>(bikeService.getAllBike(), HttpStatus.OK);
		}
		
		@GetMapping("/bikes/available")
		public ResponseEntity<List<Bike>> getAllAvailableBikes() {
		    return new ResponseEntity<>(bikeService.getAvailableBikes(), HttpStatus.OK);
		}
		
		@GetMapping("/bikes/{bikeId}")
		public ResponseEntity<Bike> getBikeById(@PathVariable long bikeId){
			return new ResponseEntity<Bike>(bikeService.getBikeById(bikeId), HttpStatus.OK);
		}

//	@GetMapping("/bikes/{location}")
//	public ResponseEntity<Bike> getBikeByLocation(@PathVariable String location){
//		return new ResponseEntity<Bike>(bikeService.getBikeByLocation(location), HttpStatus.OK);
//	}

	@GetMapping("/bikes/available/filter")
	public List<Bike> getAllAvailableBikesByLocation(@RequestParam("location") String location) {
		return bikeService.getBikeByLocation(location);
	}

		@PostMapping("/bikes")
		public ResponseEntity<Bike> saveBike(@RequestBody Bike bike){
			Bike bikeAdded = bikeService.saveBike(bike);
			return new ResponseEntity<Bike>(bikeAdded, HttpStatus.CREATED);
		}

		@PutMapping("/bikes/{bikeId}")
		public ResponseEntity<Bike> updateBike(@RequestBody Bike bikeUp, @PathVariable long bikeId){
			Bike bike = bikeService.updateBike(bikeUp, bikeId);
			return new ResponseEntity<Bike>(bike,HttpStatus.CREATED);
		}

		@DeleteMapping("/bikes/{bikeId}")
		public ResponseEntity<?> deleteBike(@PathVariable long bikeId){
			bikeService.deleteBike(bikeId);
			return new ResponseEntity<>(true,HttpStatus.OK);
		}



	}
