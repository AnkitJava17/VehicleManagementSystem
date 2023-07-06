package com.trip.model;

import java.sql.Blob;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="trip_info")
public class TripInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trip_ID;
    private Long division_ID;
	   private String source;
	   private String destination;
	   private Date startDate;
	   private Date endDate;
//	   @Column(nullable = true)
	   private Long totalDistance;
	   private LocalTime startTime;	
//	   @Column(nullable = true)
	   	private Long truck_ID;
	    private String truck_model;
	    private String truck_brand;
	    private Date truck_year;
	    private Boolean available;
	    private String truck_image;
	    private String truck_source;
	    private String truck_destination;
//	    @Column(nullable = true)
	    private Long truck_distance;
//	    @Column(nullable = true)
	    private Boolean trip_status;
		public Long getTrip_ID() {
			return trip_ID;
		}
		public void setTrip_ID(Long trip_ID) {
			this.trip_ID = trip_ID;
		}
		public Long getDivision_ID() {
			return division_ID;
		}
		public void setDivision_ID(Long division_ID) {
			this.division_ID = division_ID;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public Long getTotalDistance() {
			return totalDistance;
		}
		public void setTotalDistance(Long totalDistance) {
			this.totalDistance = totalDistance;
		}
		public LocalTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}
		public Long getTruck_ID() {
			return truck_ID;
		}
		public void setTruck_ID(Long truck_ID) {
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
		public Boolean getAvailable() {
			return available;
		}
		public void setAvailable(Boolean available) {
			this.available = available;
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
		public Long getTruck_distance() {
			return truck_distance;
		}
		public void setTruck_distance(Long truck_distance) {
			this.truck_distance = truck_distance;
		}
		public Boolean getTrip_status() {
			return trip_status;
		}
		public void setTrip_status(Boolean trip_status) {
			this.trip_status = trip_status;
		}
	    
		
	    
	    
	    
	    
	    
	    
	    
//    @OneToMany
//    private List<TripDivisionInfo> trip_divisons;
	    
	    
	    
	    
	    
	    
	    
}