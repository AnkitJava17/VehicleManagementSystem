package com.share.service;


import com.share.model.Car;
import com.share.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailableCars() {
        return (List<Car>) carRepository.findByAvailableTrue();
    }

    @Override
    public Optional<Car> getCarById(int carId) {
        return carRepository.findById(carId);
    }

    public List<Car> getCarsByRideShareId(int rideShareId) {
        return carRepository.findByRideShareId(rideShareId);
    }


    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(int carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public List<Car> getAvailableCarsByDateAndPassengers(String destination, int passengers) {
        List<Car> cars = carRepository.findByDestAndCapacity(destination, passengers);
        List<Car> res = new ArrayList<>();
        for (Car car: cars){
            if (car.isAvailable()){
                res.add(car);
            }
        }
        return res;
    }
}
