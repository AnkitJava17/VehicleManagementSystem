import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-ride-details',
  templateUrl: './ride-details.component.html',
  styleUrls: ['./ride-details.component.css']
})
export class RideDetailsComponent {
  constructor(private http: HttpClient) { }
  searchResult: any;
  date: string = "";
  passengers: number = 0;
  searchRide() {
    const apiUrl = 'http://localhost:8083/api/rides/getAllCars';
    const queryParams = `?date=${this.date}&passengers=${this.passengers}`;

    this.http.get(apiUrl + queryParams).subscribe(
      (response: any) => {
        this.searchResult = {
          date: this.date,
          passengers: this.passengers,
          carDetails: response
        };
        console.log(this.searchResult);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}