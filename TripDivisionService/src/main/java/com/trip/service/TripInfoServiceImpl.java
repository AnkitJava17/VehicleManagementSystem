package com.trip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.exception.TripInfoNotFoundException;
import com.trip.model.TripDivisionInfo;
import com.trip.model.TripInfo;
import com.trip.repository.TripInfoRepository;

@Service
public class TripInfoServiceImpl implements TripInfoService {


    @Autowired
	private TripInfoRepository tripInfoRepository;
	
    @Override
    public TripInfo getTripInfoById(Long trip_ID) throws TripInfoNotFoundException {
        Optional<TripInfo> tripInfo = tripInfoRepository.findById(trip_ID);
		if (tripInfo.isEmpty()){
			throw new TripInfoNotFoundException("Trip does not exist");
		}else{
			return tripInfo.get();
		}
        // throw new UnsupportedOperationException("Unimplemented method 'getTripInfoById'");
    }

    
    
    @Override
    public TripInfo saveTripInfo(TripInfo tripInfo) {
        // throw new UnsupportedOperationException("Unimplemented method 'getTripDivisionInfoById'");
        
			return tripInfoRepository.save(tripInfo);
    }

	@Override
	public List<TripInfo> getAllTripInfo(){
		return tripInfoRepository.findAll();
	}
	
	

//	@Override
//	public TripInfo updateTripInfo(TripInfo tripUp, long trip_ID) throws TripInfoNotFoundException {
//		Optional<TripInfo> tripInfo = tripInfoRepository.findById(trip_ID);
//		if (tripInfo.isPresent()){
////			Bike modBike = bike.get();
////			modBike.setAvailable(bikeUp.isAvailable());
////			modBike.setBike_image(bikeUp.getBike_image());
//			return tripInfoRepository.save(tripUp);
//		}else{
//			throw new TripInfoNotFoundException("TripInfo Not Present");
//		}
//	}

    
	
	
//	@Override
//	public TripInfo updateTripInfo(TripInfo tripUp, long trip_ID) throws TripInfoNotFoundException {
//	    Optional<TripInfo> tripInfoOptional = tripInfoRepository.findById(trip_ID);
//	    if (tripInfoOptional.isPresent()) {
//	        TripInfo tripInfo = tripInfoOptional.get();
//
//	        // Update the properties of the tripInfo object with the values from tripUp
//	        tripInfo.setTotalDistance(tripUp.getTotalDistance());
//	        tripInfo.setStartTime(tripUp.getStartTime());
////	        tripInfo.setEndTime(tripUp.getEndTime());
//	        tripInfo.setTrip_ID(tripUp.getTrip_ID());
//	        tripInfo.setDivision_ID(tripUp.getDivision_ID());
//	        tripInfo.setSource(tripUp.getSource());
//	        tripInfo.setDestination(tripUp.getDestination());
//	        tripInfo.setStartDate(tripUp.getStartDate());
//	        tripInfo.setEndDate(tripUp.getEndDate());
//	        tripInfo.setTruck_ID(tripUp.getTruck_ID());
//	        tripInfo.setTruck_model(tripUp.getTruck_model());
//	        tripInfo.setTruck_brand(tripUp.getTruck_brand());
//	        tripInfo.setTruck_year(tripUp.getTruck_year());
//	        tripInfo.setAvailable(tripUp.getAvailable());
//	        tripInfo.setTruck_image(tripUp.getTruck_image());
//	        tripInfo.setTruck_source(tripUp.getTruck_source());
//	        tripInfo.setTruck_destination(tripUp.getTruck_destination());
//	        tripInfo.setTruck_distance(tripUp.getTruck_distance());
//	        tripInfo.setTrip_status(tripUp.getTrip_status());
//
//	        // ... update other properties as needed
//
//	        return tripInfoRepository.save(tripInfo);
//	    } else {
//	        throw new TripInfoNotFoundException("TripInfo Not Present");
//	    }
//	}
	
	
	@Override
	public TripInfo updateTripInfo(TripInfo tripUp, Long trip_ID) throws TripInfoNotFoundException {
	    Optional<TripInfo> tripInfoOptional = tripInfoRepository.findById(trip_ID);
	    if (tripInfoOptional.isPresent()) {
	        TripInfo tripInfo = tripInfoOptional.get();

	        // Update the properties of the tripInfo object with the values from tripUp
	        tripInfo.setDivision_ID(tripUp.getDivision_ID());
	        tripInfo.setSource(tripUp.getSource());
	        tripInfo.setDestination(tripUp.getDestination());
	        tripInfo.setStartDate(tripUp.getStartDate());
	        tripInfo.setEndDate(tripUp.getEndDate());
	        tripInfo.setTotalDistance(tripUp.getTotalDistance());
	        tripInfo.setStartTime(tripUp.getStartTime());
	        tripInfo.setTruck_ID(tripUp.getTruck_ID());
	        tripInfo.setTruck_model(tripUp.getTruck_model());
	        tripInfo.setTruck_brand(tripUp.getTruck_brand());
	        tripInfo.setTruck_year(tripUp.getTruck_year());
	        tripInfo.setAvailable(tripUp.getAvailable());
	        tripInfo.setTruck_image(tripUp.getTruck_image());
	        tripInfo.setTruck_source(tripUp.getTruck_source());
	        tripInfo.setTruck_destination(tripUp.getTruck_destination());
	        tripInfo.setTruck_distance(tripUp.getTruck_distance());
	        tripInfo.setTrip_status(tripUp.getTrip_status());

	        // ... update other properties as needed

	        return tripInfoRepository.save(tripInfo);
	    } else {
	        throw new TripInfoNotFoundException("TripInfo Not Present");
	    }
	}

    
}
