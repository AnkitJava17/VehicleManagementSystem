package com.trip.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.exception.TripDivisionInfoNotFoundException;
import com.trip.model.TripDivisionInfo;


@Service
public interface TripDivisionInfoService {
    

    //    List<Truck> findAllByAvailable(boolean available);

//     public List<TripDivisionInfo> getAvailableTripDivisionInfo();

    public TripDivisionInfo getTripDivisionInfoById(long division_ID) throws TripDivisionInfoNotFoundException;

    // public TripDivisionInfo getTripDivisionInfoByName(String truckName) throws TripDivisionInfoNotFoundException;

     public TripDivisionInfo saveTripDivisionInfo(TripDivisionInfo tripDivisionInfo);


     public List<TripDivisionInfo> getAllTripDivisionInfo();

    // public Truck updateTruck(Truck truck, long id) throws TruckNotFoundException;

    // public void deleteTruck(long id) throws TruckNotFoundException;


}
