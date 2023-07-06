package com.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.model.Truck;
import com.trip.service.TruckService;

@CrossOrigin(origins ="http://localhost:4200" )
@RestController
@RequestMapping("api/trip")
public class TruckController {
    
    @Autowired
	private TruckService truckService;
	
	@GetMapping("/truck")
	public ResponseEntity<List<Truck>> getAllTruck(){
		return new ResponseEntity<>(truckService.getAllTruck(), HttpStatus.OK);
	}
		
	@GetMapping("/truck/available")
	public List<Truck> getAllAvailableTrucks() {
	    return truckService.getAvailableTrucks();
	}

	@GetMapping("/truck/{truckId}")
	public Truck getTruckById(@PathVariable long truckId){
		return truckService.getTruckById(truckId);
	}
	

	@PostMapping("/truck")
	public ResponseEntity<Truck> saveTruck(@RequestBody Truck truck){
		Truck truckAdded = truckService.saveTruck(truck);
		return new ResponseEntity<Truck>(truckAdded, HttpStatus.CREATED);
	}

	@PutMapping("/truck/{truckId}")
	public ResponseEntity<Truck> updateTruck(@RequestBody Truck truckUp, @PathVariable long truckId){
		Truck truck = truckService.updateTruck(truckUp, truckId);
		return new ResponseEntity<Truck>(truck,HttpStatus.CREATED);
	}

	@DeleteMapping("/truck/{truckId}")
	public ResponseEntity<?> deleteTruck(@PathVariable long truckId){
		truckService.deleteTruck(truckId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
}
