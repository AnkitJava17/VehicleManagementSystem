import { Component, Input, OnInit } from '@angular/core';
import { RentCars } from '../rent-cars/rentCar';
import { RentalService } from 'app/services/rental.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-rent-cars',
  templateUrl: './rent-cars.component.html',
  styleUrls: ['./rent-cars.component.css']
})
export class RentCarsComponent implements OnInit {
  // @Input() disabled: boolean = false;
  images: any;
  responsiveOptions;
  constructor(private rentService: RentalService, private route: Router) {
    this.responsiveOptions = [{
      breakpoint: '1024px',
      numVisible: 1,
      numScroll: 3
    }];
  }

  ngOnInit(): void {
    this.getAvailableCars();

  }
  // availableCars: RentCars[] = [];
  // getAvailableCars() {
  //   this.rentService.getAvailableCars().subscribe(
  //     (rentCars: RentCars[]) => {
  //       this.availableCars = rentCars;
  //     },
  //     (error) => {
  //       console.error(error);
  //     }
  //   );
  // }


  availableCars: RentCars[] = [];
  carImages: string[] = [];



  getAvailableCars() {
    this.rentService.getAvailableCars().subscribe(
      (rentCars: RentCars[]) => {
        this.availableCars = rentCars;
        this.carImages = rentCars.map((car: RentCars) => car.car_image);
      },
      (error) => {
        console.error(error);
      }
    );
  }


  bookCar(rentCars: RentCars) {

    alert("car booked");
    console.log('Booking car:', rentCars);
    this.route.navigate(['booked']);
  }
}
