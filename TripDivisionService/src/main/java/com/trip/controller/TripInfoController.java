package com.trip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.model.TripDivisionInfo;
import com.trip.model.TripInfo;
import com.trip.service.TripInfoService;

@CrossOrigin(origins ="http://localhost:4200" )
@RestController
@RequestMapping("api/trip")
public class TripInfoController {

    
	@Autowired
	private TripInfoService tripInfoService;
    
     @GetMapping("/tripinfo")
		 public ResponseEntity<List<TripInfo>> getAllTripInfo(){
		 	return new ResponseEntity<>(tripInfoService.getAllTripInfo(), HttpStatus.OK);
		 }
		
		// @GetMapping("/tripdiv/available")
		// public ResponseEntity<List<TripDivisionInfo>> getAllAvailableTripDivisionInfo() {
		//     return new ResponseEntity<>(tripDivisionInfoService.getAllAvailableTripDivisionInfo(), HttpStatus.OK);
		// }
		
		@GetMapping("/tripinfo/{trip_ID}")
		public ResponseEntity<TripInfo> getTripInfoById(@PathVariable long trip_ID){
			return new ResponseEntity<TripInfo>(tripInfoService.getTripInfoById(trip_ID), HttpStatus.OK);
		}

		 @PostMapping("/tripinfo")
		 public ResponseEntity<TripInfo> saveTripInfo(@RequestBody TripInfo tripInfo){
		 	TripInfo tripInfoAdded = tripInfoService.saveTripInfo(tripInfo);
		 	return new ResponseEntity<TripInfo>(tripInfoAdded, HttpStatus.CREATED);
		 }

		 @PatchMapping("/tripinfo/{trip_ID}")
		 public ResponseEntity<TripInfo> updateTripInfo(@RequestBody TripInfo tripUp, @PathVariable Long trip_ID){
		 	TripInfo tripInfo = tripInfoService.updateTripInfo(tripUp, trip_ID);
		 	return new ResponseEntity<TripInfo>(tripInfo,HttpStatus.CREATED);
		 }

		// @DeleteMapping("/bikes/{bikeId}")
		// public ResponseEntity<?> deleteBike(@PathVariable long bikeId){
		// 	bikeService.deleteBike(bikeId);
		// 	return new ResponseEntity<>(true,HttpStatus.OK);
		// }




}
