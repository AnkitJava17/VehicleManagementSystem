package com.share.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;

    private String carModel;

    private String carBrand;

    private int carYear;

    private boolean available;

    private int carCapacity;

    private String carImage;

    private String carDriver;

    @ManyToOne
    @JoinColumn(name = "ride_ID")
    private RideShare rideShare;

    public RideShare getRideShare() {
        return rideShare;
    }

    public void setRideShare(RideShare rideShare) {
        this.rideShare = rideShare;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(String carDriver) {
        this.carDriver = carDriver;
    }

    public Car() {
    };

    public Car(int carId, String carModel, String carBrand, int carYear, boolean available,
            int carCapacity, String carImage, String carDriver, RideShare rideShare) {
        this.carId = carId;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carYear = carYear;
        this.available = available;
        this.carCapacity = carCapacity;
        this.carImage = carImage;
        this.carDriver = carDriver;
        this.rideShare = rideShare;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId + ", carModel=" + carModel + ", carBrand=" + carBrand + ", carYear=" + carYear
                + ", available=" + available + ", carCapacity=" + carCapacity + ", carImage=" + carImage
                + ", carDriver=" + carDriver + "]";
    }

}