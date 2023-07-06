package com.trip.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="truck")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long truck_ID;
    private String truck_model;
    private String truck_brand;
    private Date truck_year;
    private Boolean available;
    private String truck_image;
    private String truck_source;
    private String truck_destination;
    private long truck_distance;
    private Boolean truck_status;
	
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	// Vehicle vehicle_ID;
	public long getTruck_ID() {
		return truck_ID;
	}
	public void setTruck_ID(long truck_ID) {
		this.truck_ID = truck_ID;
	}
	public String getTruck_model() {
		return truck_model;
	}
	public void setTruck_model(String truck_model) {
		this.truck_model = truck_model;
	}
	public String getTruck_brand() {
		return truck_brand;
	}
	public void setTruck_brand(String truck_brand) {
		this.truck_brand = truck_brand;
	}
	public Date getTruck_year() {
		return truck_year;
	}
	public void setTruck_year(Date truck_year) {
		this.truck_year = truck_year;
	}
	
	
	
	
	public String getTruck_image() {
		return truck_image;
	}
	public void setTruck_image(String truck_image) {
		this.truck_image = truck_image;
	}
	
	
	
	public String getTruck_source() {
		return truck_source;
	}
	public void setTruck_source(String truck_source) {
		this.truck_source = truck_source;
	}
	public String getTruck_destination() {
		return truck_destination;
	}
	public void setTruck_destination(String truck_destination) {
		this.truck_destination = truck_destination;
	}
	public long getTruck_distance() {
		return truck_distance;
	}
	public void setTruck_distance(long truck_distance) {
		this.truck_distance = truck_distance;
	}
	
	
	public Boolean getTruck_status() {
		return truck_status;
	}
	public void setTruck_status(Boolean truck_status) {
		this.truck_status = truck_status;
	}
	@Override
	public String toString() {
		return "Truck [truck_ID=" + truck_ID + ", truck_model=" + truck_model + ", truck_brand=" + truck_brand
				+ ", truck_year=" + truck_year + "]";
	}

	
}
