package com.rent.RentalService.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Bike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long bikeID;

    private String name;

    private String model;

    private String brand;

    private Date year;

    private boolean available;

    private String bike_image;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bike> bikes;
    public Bike() {
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID=" + bikeID +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", available=" + available +
                ", bike_image='" + bike_image + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Bike(long bikeID, String name, String model, String brand, Date year, boolean available, String bike_image, String location) {
        this.bikeID = bikeID;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.available = available;
        this.bike_image = bike_image;
        this.location = location;
    }

    public long getBikeID() {
        return bikeID;
    }

    public void setBikeID(long bikeID) {
        this.bikeID = bikeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBike_image() {
        return bike_image;
    }

    public void setBike_image(String bike_image) {
        this.bike_image = bike_image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
