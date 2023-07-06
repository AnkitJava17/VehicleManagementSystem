import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RentCars } from '../rent-cars/rentCar';
import { RentalService } from 'app/services/rental.service';
import { Router } from '@angular/router';
import { RentBikes } from '../rent-bike/rentBike';

@Component({
  selector: 'app-vehicle-rental',
  templateUrl: './vehicle-rental.component.html',
  styleUrls: ['./vehicle-rental.component.css']
})
export class VehicleRentalComponent implements OnInit {

  isDisabled: boolean = true;
  searchForm:any;

  disableComponent() {
    this.isDisabled = false;
  }


  minDate: Date;
  searchResult: RentCars[] = [];
  location: string = "";
  availableCars: RentCars[] = [];
  searchResult1: RentBikes[] = [];
  availableBikes: RentBikes[] = [];
  constructor(private http: HttpClient, private rentalService: RentalService, private route: Router) {
    this.minDate = new Date();
    this.location = '';
    this.availableCars = [];

  }

  searchCars(): void {
    // this.disableComponent();

    this.rentalService.getAvailableCarsByLocation(this.location).subscribe((rentCars: RentCars[]) => {
      this.availableCars = rentCars;
      this.carImages = rentCars.map((car: RentCars) => car.car_image);
    },
      (error) => {
        console.log(error)
      }
    );
    console.log(this.availableCars);

    this.rentalService.getAvailableBikesByLocation(this.location).subscribe((rentBike: RentBikes[]) => {
      this.availableBikes = rentBike;
      this.carImages = rentBike.map((bike: RentBikes) => bike.bike_image);
    },
      (error) => {
        console.log(error)
      }
    );
    // console.log(this.availableCars);
  }

  ngOnInit(): void {
    this.searchCars();

  }
  cities = ['Pune', 'Mumbai', 'Chennai', 'Nashik'];



  carImages: string[] = [];
  bikeImages: string[] = [];

  bookCar(rentCars: RentCars) {

    alert("car booked");
    console.log('Booking car:', rentCars);
    this.route.navigate(['booked']);
  }
  bookBikes(rentBike: RentBikes) {
    alert("Bike booked");
    console.log('Booking Bike:', rentBike);
    this.route.navigate(['booked']);
  }
}
