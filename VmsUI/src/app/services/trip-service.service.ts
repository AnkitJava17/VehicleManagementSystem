import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TripDivisionForm } from '../components/trip-division-form/trip-division-form';
import { Truck } from '../components/trip-division/truck';

@Injectable({
  providedIn: 'root'
})
export class TripServiceService {

  
  private apiUrl = 'http://localhost:8089/api/trip';

  constructor(private http: HttpClient) { }

  getAvailableTruck(): Observable<Truck[]> {
    return this.http.get<Truck[]>(`${this.apiUrl}/truck`);
  }



  saveTripDivisionInfo(form: TripDivisionForm): Observable<TripDivisionForm>{
    return this.http.post<TripDivisionForm>(`${this.apiUrl}/tripdiv`,form);
    // console.log("save");
  }

  saveTripInfo(form: TripDivisionForm): Observable<TripDivisionForm>{
    return this.http.post<TripDivisionForm>(`${this.apiUrl}/tripinfo`,form);
    console.log("save");
  }

  updateTripForm(form: TripDivisionForm,  trip_ID: number): Observable<TripDivisionForm>{
    return this.http.patch<TripDivisionForm>(`${this.apiUrl}/tripinfo/${trip_ID}`,form);
    console.log("save");
  }
  updateTruckForm(form: Truck,  trip_ID: number): Observable<Truck>{
    return this.http.patch<Truck>(`${this.apiUrl}/tripinfo/${trip_ID}`,form);
    console.log("save");
  }


}
