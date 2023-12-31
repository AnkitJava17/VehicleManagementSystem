import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from 'app/components/ride-share-cars/car';


@Injectable({
  providedIn: 'root'
})
export class ShareCarService {

  private apiUrl = 'http://localhost:8083/api/rides/cars';

  constructor(private http: HttpClient) { }

  getAvailableCars(destination:String, passengers:number): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/available/filter?destination=${destination}&passengers=${passengers}`);
  }

  getAllAvailableCars(): Observable<Car[]>{
    return this.http.get<Car[]>(`${this.apiUrl}/available`);
  }
  
}
