import { Component, OnInit } from '@angular/core';
import { Car } from './car';
import { ShareCarService } from 'app/services/share-car.service';

import { Router } from '@angular/router';
import { MapServiceService } from 'app/services/map-service.service';
@Component({
  selector: 'app-ride-share-cars',
  templateUrl: './ride-share-cars.component.html',
  styleUrls: ['./ride-share-cars.component.css'],
})
export class RideShareCarsComponent implements OnInit {
  availableCars: Car[] = [];

  constructor(
    private shareCarService: ShareCarService,
    private mapService: MapServiceService,
    private route: Router
  ) {}

  ngOnInit() {
    this.getAvailableCars();
  }

  getAvailableCars() {
    this.availableCars = this.mapService.getResult();
  }

  bookCar(car: Car) {
    alert('car booked');
    console.log('Booking car:', car);
    this.route.navigate(['my-bookings']);
  }
}
