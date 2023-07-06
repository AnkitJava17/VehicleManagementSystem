package com.rent.RentalService.repository;

import com.rent.RentalService.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rent.RentalService.model.Bike;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
    public Bike findByName(String Name);
    
    public Iterable<Bike> findByAvailableTrue();

    @Query("select b from Bike b where b.location=?1")
    public List<Bike> findByLocation(String location);
}
