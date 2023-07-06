import { Component } from '@angular/core';

import { RentalService } from 'app/services/rental.service';
import { Router } from '@angular/router';
import { RentBikes } from './rentBike';

@Component({
  selector: 'app-rent-bike',
  templateUrl: './rent-bike.component.html',
  styleUrls: ['./rent-bike.component.css']
})
export class RentBikeComponent {
  constructor(private rentService: RentalService, private route: Router) { }
  ngOnInit(): void {
    this.getAvailableBikes();
  }
  availableBikes: RentBikes[] = [];
  bikeImages: string[] = [];

  getAvailableBikes() {
    this.rentService.getAvailableBikes().subscribe(
      (rentBikes: RentBikes[]) => {
        this.availableBikes = rentBikes;
        this.bikeImages = rentBikes.map((bike: RentBikes) => bike.bike_image);
      },
      (error) => {
        console.error(error);
      }
    );
  }
  bookBike(rentBikes: RentBikes) {

    alert("Bike booked");
    console.log('Booking Bike:', rentBikes);
    this.route.navigate(['booked']);
  }
}

