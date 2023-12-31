package com.rent.RentalService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rent.RentalService.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.RentalService.exception.BikeNotFoundException;
import com.rent.RentalService.model.Bike;
import com.rent.RentalService.repository.BikeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired 
	private BikeRepository bikeRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Bike> getAllBike(){
		return bikeRepository.findAll();
	}
	
	@Override
	public Bike getBikeById(long id) throws BikeNotFoundException{
		Optional<Bike> bike = bikeRepository.findById(id);
		if (bike.isPresent()){
			return bike.get();
		}else{
			throw new BikeNotFoundException("Not Found");
		}
	}
	
	@Override
	public Bike saveBike(Bike bike) {
		Bike bikeSaved = bikeRepository.save(bike);
		return bikeSaved;
	}


	@Override
	public List<Bike> getAvailableBikes() {
		return (List<Bike>) bikeRepository.findByAvailableTrue();
	}

	@Override
	public Bike getBikeByName(String bikeName) throws BikeNotFoundException {
		Bike bike = bikeRepository.findByName(bikeName);
		if (bike == null){
			throw new BikeNotFoundException("Bike not present");
		}else{
			return bike;
		}
	}

	@Override
	public List<Bike> getBikeByLocation(String location) {
		List<Bike> bikes = (List<Bike>) bikeRepository.findByLocation(location);
		List<Bike> bikes1 = new ArrayList<>();
		for (Bike bike: bikes){
			if (bike.isAvailable()){
				bikes1.add(bike);
			}
		}
		return bikes1;
	}


	@Override
	public Bike updateBike(Bike bikeUp, long id) throws BikeNotFoundException {
		Optional<Bike> bike = bikeRepository.findById(id);
		if (bike.isPresent()){
//			Bike modBike = bike.get();
//			modBike.setAvailable(bikeUp.isAvailable());
//			modBike.setBike_image(bikeUp.getBike_image());
			return bikeRepository.save(bikeUp);
		}else{
			throw new BikeNotFoundException("Bike Not Present");
		}
	}

	@Override
	public void deleteBike(long id) throws BikeNotFoundException {
		Optional<Bike> bike = bikeRepository.findById(id);
		if (bike.isEmpty()) {
			throw new BikeNotFoundException("Not Found");
		}else {
			bikeRepository.deleteById(id);
		}
	}

}
