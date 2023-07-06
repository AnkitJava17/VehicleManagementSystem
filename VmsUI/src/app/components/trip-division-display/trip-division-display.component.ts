import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RouterService } from 'app/services/router.service';
import { TripServiceService } from 'app/services/trip-service.service';
import { TripSharedDataService } from 'app/services/trip-shared-data.service';
import { Truck } from '../trip-division/truck';
import { TripDivisionForm } from '../trip-division-form/trip-division-form';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-trip-division-display',
  templateUrl: './trip-division-display.component.html',
  styleUrls: ['./trip-division-display.component.css']
})
export class TripDivisionDisplayComponent {


  // tripForm!: FormGroup;
  info:TripDivisionForm;
  card:Truck;

  constructor(
    private fb: FormBuilder,
    private snack: MatSnackBar,
    private tripServe: TripServiceService,
    private routerService: RouterService,
    private sharedData:TripSharedDataService,
    
  ) 
  {
    this.info = sharedData.getFormData();
    this.card = sharedData.getData();
  }


  ngOnInit(): void {
    
    this.retrieveDataFromSessionStorage();

    sessionStorage.setItem('cardData', JSON.stringify(this.card));
    sessionStorage.setItem('infoData', JSON.stringify(this.info));
  
  }

  retrieveDataFromSessionStorage(): void {
    const cardData = sessionStorage.getItem('cardData');
    const infoData = sessionStorage.getItem('infoData');

    if (cardData && infoData) {
      this.card = JSON.parse(cardData);
      this.info = JSON.parse(infoData);
    } else {
      // Handle case when data is not found in sessionStorage
    }
}
}