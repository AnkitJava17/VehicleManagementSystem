package com.share.repository;

import com.share.model.Car;
import com.share.model.RideShare;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RideShareRepository extends JpaRepository<RideShare,Integer> {

    
}
