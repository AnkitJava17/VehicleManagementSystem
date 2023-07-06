import { ViewportScroller } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RouterService } from '../../services/router.service';
import { TripServiceService } from '../../services/trip-service.service';
import { TripSharedDataService } from '../../services/trip-shared-data.service';
import { Truck } from './truck';

interface Card {
  id: number;
  image: string;
  title: string;
  subtitle: string;
  description: string;
  status: boolean;
}

@Component({
  selector: 'app-trip-division',
  templateUrl: './trip-division.component.html',
  styleUrls: ['./trip-division.component.css'],
})
export class TripDivisionComponent {
  cards: Truck[] = [];
  card:Truck;
  isClickable:boolean;
  isDisabled: boolean = false;


  constructor(
    private viewportScroller: ViewportScroller,
    public dialog: MatDialog,
    private tripService: TripServiceService,
    private routerService: RouterService,
    private route: Router,
    private sharedData:TripSharedDataService
  ) {
    this.tripService.getAvailableTruck().subscribe(
      data => this.cards = data
    );
    this.card = new Truck();


    this.isClickable = this.card.truck_status;

  }



toTripDivisionForm(dataOfCard:Truck){
  // console.log(this.cards.get);
  this.sharedData.setData(dataOfCard);
  
  // this.route.navigate(['trip-division-form']);
  this.routerService.toTripDivisionForm();
}

  // scrollToCards(): void {
  //   const element = document.getElementById('cardsSection');
  //   if (element) {
  //     element.scrollIntoView({ behavior: 'smooth' });
  //   }
  // }

  scrollToBanner(): void {
    const element = document.querySelector('.banner');
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
    }
  }
}

