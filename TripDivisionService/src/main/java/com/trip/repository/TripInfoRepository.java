package com.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trip.model.TripInfo;

@Repository
public interface TripInfoRepository extends JpaRepository<TripInfo,Long> {
	
	@Query("select t from TripInfo t where t.trip_ID=?1")
	public TripInfo findByIdTripInfo(Long trip_ID);
    
//    public Iterable<TripInfo> findByAvailableTrue();

}
