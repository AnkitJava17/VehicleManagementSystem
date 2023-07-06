package com.trip.model;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="trip_division_info")
public class TripDivisionInfo {
	

//	private Long division_ID;

//    @ManyToOne
//	private long trip_ID;
//
//	private int User ;
//
//	private int arrivalId;
//
//	private int destinationId;
//
//	private int payment_ID;

       @Id
       @GeneratedValue
	   private Long division_ID;
	   private String source;
	   private String destination;
	   private Date startDate;
	   private Date endDate;
	   private int totalDistance;
//	   private LocalTime travelTime;
	   private LocalTime startTime;
	   
//	   private Blob division_image;
//	   @Lob
//	    private byte[] division_image;
//	   private File division_image;
	     
//	public TripDivisionInfo(Long division_ID, String source, String destination, Date startDate, Date endDate,
//			int totalDistance, int travelTime, int startTime) {
//		super();
//		this.division_ID = division_ID;
//		this.source = source;
//		this.destination = destination;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.totalDistance = totalDistance;
//		this.travelTime = travelTime;
//		this.startTime = startTime;
//	}
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
	public int getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}
	
	
//	public LocalTime getTravelTime() {
//		return travelTime;
//	}
//	public void setTravelTime(LocalTime travelTime) {
//		this.travelTime = travelTime;
//	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime starTime) {
		this.startTime = starTime;
	}

	
	
	
	
//public Time getTravelTime() {
//		return travelTime;
//	}
//	public void setTravelTime(Time travelTime) {
//		this.travelTime = travelTime;
//	}
//	public Time getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(Time startTime) {
//		this.startTime = startTime;
//	}
//		public String getTravelTime() {
//		return travelTime;
//	}
//	public void setTravelTime(String travelTime) {
//		this.travelTime = travelTime;
//	}
//	public String getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(String startTime) {
//		this.startTime = startTime;
//	}
//	@Override
//	public String toString() {
//		return "TripDivisionInfo [division_ID=" + division_ID + ", source=" + source + ", destination=" + destination
//				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalDistance=" + totalDistance
//				+ ", travelTime=" + travelTime + ", startTime=" + startTime + "]";
//	}
	   
	
	
	
}
