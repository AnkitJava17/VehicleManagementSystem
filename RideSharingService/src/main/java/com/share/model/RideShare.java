package com.share.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import java.util.List;

@Entity
public class RideShare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ride_ID;

    private String ride_source;

    private String ride_destination;

    private String departure_time;

    private String arrival_time;

    private int ride_duration;

    private float ride_km;

    private float ride_rate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getRide_ID() {
        return ride_ID;
    }

    public void setRide_ID(int ride_ID) {
        this.ride_ID = ride_ID;
    }

    public String getRide_source() {
        return ride_source;
    }

    public void setRide_source(String ride_source) {
        this.ride_source = ride_source;
    }

    public String getRide_destination() {
        return ride_destination;
    }

    public void setRide_destination(String ride_destination) {
        this.ride_destination = ride_destination;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String depature_time) {
        this.departure_time = depature_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getRide_duration() {
        return ride_duration;
    }

    public void setRide_duration(int ride_duration) {
        this.ride_duration = ride_duration;
    }

    public float getRide_km() {
        return ride_km;
    }

    public void setRide_km(float ride_km) {
        this.ride_km = ride_km;
    }

    public float getRide_rate() {
        return ride_rate;
    }

    public void setRide_rate(float ride_rate) {
        this.ride_rate = ride_rate;
    }

    public RideShare(){};

    // Constructor
    public RideShare(int ride_ID, String ride_source, String ride_destination, String departure_time,
                     String arrival_time, int ride_duration, float ride_km, float ride_rate) {
        this.ride_ID = ride_ID;
        this.ride_source = ride_source;
        this.ride_destination = ride_destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.ride_duration = ride_duration;
        this.ride_km = ride_km;
        this.ride_rate = ride_rate;
    }

    @Override
    public String toString() {
        return "RideShare [ride_ID=" + ride_ID + ", ride_source=" + ride_source + ", ride_destination="
                + ride_destination + ", departure_time=" + departure_time + ", arrival_time=" + arrival_time
                + ", ride_duration=" + ride_duration + ", ride_km=" + ride_km + ", ride_rate=" + ride_rate + "]";
    }
}
