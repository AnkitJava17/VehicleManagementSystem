package com.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trip.model.Truck;


@Repository
public interface TruckRepository extends JpaRepository<Truck,Long> {

	@Query("select t from Truck t where t.truck_model=?1")
	public Truck findByName(String Name);
    
    public Iterable<Truck> findByAvailableTrue();
}
