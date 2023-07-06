package com.rent.RentalService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rent.RentalService.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findByName(String Name);
    
    public Iterable<Car> findByAvailableTrue();

    @Query("select c from Car c where c.location=?1")
    public List<Car> findByLocation(String location);
}
