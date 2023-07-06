package com.trip.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.trip.exception.TripInfoNotFoundException;
import com.trip.model.TripInfo;

@Service
public interface TripInfoService {
    

    //    List<Truck> findAllByAvailable(boolean available);

//     public List<Truck> getAvailableTrucks();

    public TripInfo getTripInfoById(Long trip_ID) throws TripInfoNotFoundException;

//    public TripInfo getTripInfoByName(String trip_name) throws TripInfoNotFoundException;

     public TripInfo saveTripInfo(TripInfo tripInfo);

     public List<TripInfo> getAllTripInfo();

     public TripInfo updateTripInfo(TripInfo tripInfo, Long trip_ID) throws TripInfoNotFoundException;

    // public void deleteTruck(long id) throws TruckNotFoundException;


}
