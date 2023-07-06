import { Injectable } from '@angular/core';
import { TripDivisionForm } from 'app/components/trip-division-form/trip-division-form';
import { Truck } from 'app/components/trip-division/truck';
import { TripServiceService } from './trip-service.service';

@Injectable({
  providedIn: 'root'
})
export class TripSharedDataService {

  card:Truck; info: TripDivisionForm;
  constructor() { 
    this.card = new Truck();
    this.info = new TripDivisionForm();

  }

  setData(card:Truck){
    this.card = card;
  }

  getData(){
    return this.card;
  }

  setFormData(info:TripDivisionForm){
    this.info = info;
  }

  getFormData(){
    return this.info;
  }

}
