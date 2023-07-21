package com.share.repository;


import com.share.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    public Iterable<Car> findByAvailableTrue();

    @Query("select c from Car c join RideShare r on c.rideId=r.ride_ID where c.carCapacity >= ?2 and r.ride_destination=?1")
    public List<Car> findByDestAndCapacity(String destination, int carCapacity);


    @Query("SELECT c FROM Car c WHERE c.rideId = ?1")
    List<Car> findByRideShareId(int rideId);


}
