import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TripServiceService } from 'app/services/trip-service.service';
import { Truck } from '../trip-division/truck';
import { RouterService } from 'app/services/router.service';
import { TripSharedDataService } from 'app/services/trip-shared-data.service';
import { ValidatorFn, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-trip-division-form',
  templateUrl: './trip-division-form.component.html',
  styleUrls: ['./trip-division-form.component.css'],
})
export class TripDivisionFormComponent implements OnInit {
  tripForm!: FormGroup;
  card: Truck;

  constructor(
    private fb: FormBuilder,
    private snack: MatSnackBar,
    private tripServe: TripServiceService,
    private routerService: RouterService,
    private sharedData: TripSharedDataService,
  ) {
    this.card = sharedData.getData();
  }

  ngOnInit(): void {
    this.tripForm = this.fb.group({
      source: ['', Validators.required],
      destination: ['', Validators.required],
      startDate: ['', [Validators.required, dateValidator()]],
      endDate: ['', [Validators.required, dateValidator(), endDateValidator()]],
      totalDistance: ['', [Validators.required, Validators.min(100)]],
      startTime: ['', Validators.required],
      division_image: ['']
    });
  }

  getCurrentDateTime(): string {
    const now = new Date();
    const year = now.getFullYear();
    const month = (now.getMonth() + 1).toString().padStart(2, '0');
    const day = now.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }

  // submitTrip() {
  //   if (this.tripForm.valid) {
  //     const tripData = this.tripForm.value;
  //     console.log(tripData);
  //     this.sharedData.setFormData(tripData);

  //     this.tripServe.saveTripDivisionInfo(tripData).subscribe(
  //       (response) => {
  //         console.log('Trip Division Info saved successfully', response);
  //         // Reset the form or perform any other actions
  //       },
  //       (error) => {
  //         console.error('Error saving Trip Division Info', error);
  //         // Handle the error appropriately
  //       }
  //     );

  //     this.routerService.toTripDivisionDisplay();
  //   }
  // }

  submitTrip() {
    // Mark all form controls as touched
    this.markFormGroupTouched(this.tripForm);
  
    // Check if any form control is invalid
    if (this.tripForm.invalid) {
      // Display validation errors
      this.snack.open('Please fill in all required fields.', 'OK');
      return;
    }
  
    // Submit the form if it is valid
    const tripData = this.tripForm.value;
    console.log(tripData);
    this.sharedData.setFormData(tripData);
  
    this.tripServe.saveTripDivisionInfo(tripData).subscribe(
      (response) => {
        console.log('Trip Division Info saved successfully', response);
        // Reset the form or perform any other actions
      },
      (error) => {
        console.error('Error saving Trip Division Info', error);
        // Handle the error appropriately
      }
    );
  
    this.routerService.toTripDivisionDisplay();
  }
  
  markFormGroupTouched(formGroup: FormGroup) {
    Object.values(formGroup.controls).forEach(control => {
      control.markAsTouched();
  
      if (control instanceof FormGroup) {
        this.markFormGroupTouched(control);
      }
    });
  }

  
}

export function dateValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const currentDate = new Date();
    const selectedDate = new Date(control.value);

    if (selectedDate.getTime() < currentDate.setHours(0, 0, 0, 0)) {
      return { pastDate: true };
    }

    return null;
  };
}

export function endDateValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    const startDate = new Date(control.parent?.get('startDate')?.value);
    const endDate = new Date(control.value);

    if (endDate.getTime() < startDate.getTime()) {
      return { endDateBeforeStartDate: true };
    }

    return null;
  };
}
