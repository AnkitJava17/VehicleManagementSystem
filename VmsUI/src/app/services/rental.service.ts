import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RentBikes } from 'app/components/rent-bike/rentBike';
import { RentCars } from 'app/components/rent-cars/rentCar';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RentalService {
  private apiUrl = 'http://localhost:8082/api/rentals';
  private apiUrl1 = 'http://localhost:8082/api/rentals';
  constructor(private http: HttpClient) { }

  getAvailableCars(): Observable<RentCars[]> {
    return this.http.get<RentCars[]>(`${this.apiUrl}/cars/available`);
  }
  getAvailableBikes(): Observable<RentBikes[]> {
    return this.http.get<RentBikes[]>(`${this.apiUrl}/bikes/available`);
  }

  getAvailableCarsByLocation(location: String): Observable<RentCars[]> {

    return this.http.get<RentCars[]>(`${this.apiUrl1}/cars/available/filter?location=${location}`);

  }
  getAvailableBikesByLocation(location: String): Observable<RentBikes[]> {

    return this.http.get<RentBikes[]>(`${this.apiUrl1}/bikes/available/filter?location=${location}`);

  }

}
