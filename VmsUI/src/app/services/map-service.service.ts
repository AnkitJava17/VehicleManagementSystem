import { Injectable } from '@angular/core';
import { Car } from 'app/components/ride-share-cars/car';

@Injectable({
  providedIn: 'root'
})
export class MapServiceService {

  source:string;
  destination:string;
  result:Car[];
  constructor() { 
    this.source = '';
    this.destination = '';
    this.result = [];
  }

  setLocation(source:string, destination:string){
    this.source = source;
    this.destination = destination;
  }
  getSource(){
    return this.source;
  }
  getDestination(){
    return this.destination;
  }

  setResult(result:Car[]){
    this.result = result;
  }

  getResult(){
    return this.result;
  }
}
