import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RentBike } from '../admin/RentBike';
import { RentCar } from '../admin/RentCar';
import { RentVehicleInfo } from '../admin/RentVehicle';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-rental',
  templateUrl: './admin-rental.component.html',
  styleUrls: ['./admin-rental.component.css']
})

export class AdminRentalComponent implements OnInit {

    bikes: RentBike[] = [];
    cars: RentCar[] = [];
    rentDetails: RentVehicleInfo[] = [];
  
    bikeName!: string;
    carName!: string;
    vehicleName!: string;
    rentDuration!: string;
    customerName!: string;
  
    constructor(private http: HttpClient) { }
  
    ngOnInit() {
      this.getAllBikes();
      this.getAllCars();
      this.getRentDetails();
    }
  
    getAllBikes() {
      this.http.get<RentBike[]>('http://localhost:8080/admin/rental/bikes')
        .subscribe((response) => {
          this.bikes = response;
        });
    }
  
    getAllCars() {
      this.http.get<RentCar[]>('http://localhost:8080/admin/rental/cars')
        .subscribe((response) => {
          this.cars = response;
        });
    }
  
    getRentDetails() {
      this.http.get<RentVehicleInfo[]>('http://localhost:8080/admin/info')
        .subscribe((response) => {
          this.rentDetails = response;
        });
    }
  
    addBike() {
      const newBike: RentBike = {
        name: this.bikeName,
      };
  
      this.http.post<RentBike>('http://localhost:8080/admin/rental/bikes', newBike)
        .subscribe((response) => {
          this.bikes.push(response);
          this.resetBikeForm();
        });
    }
  
    addCar() {
      const newCar: RentCar = {
        name: this.carName,
      };
  
      this.http.post<RentCar>('http://localhost:8080/admin/rental/cars', newCar)
        .subscribe((response) => {
          this.cars.push(response);
          this.resetCarForm();
        });
    }
  
    addInfo() {
      const newInfo: RentVehicleInfo = {
        vehicleName: this.vehicleName,
        rentDuration: this.rentDuration,
        customerName: this.customerName
      };
  
      this.http.post<RentVehicleInfo>('http://localhost:8080/admin/rental/info', newInfo)
        .subscribe((response) => {
          this.rentDetails.push(response);
          this.resetInfoForm();
        });
    }
  
    resetBikeForm() {
      this.bikeName = '';
    }
  
    resetCarForm() {
      this.carName = '';
    }
  
    resetInfoForm() {
      this.vehicleName = '';
      this.rentDuration = '';
      this.customerName = '';
    }
  }
  