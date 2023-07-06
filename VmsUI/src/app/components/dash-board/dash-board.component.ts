import { Component, OnInit } from '@angular/core';
import { RouterService } from '../../services/router.service';

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {
  images: any;
  responsiveOptions;
  constructor(private routerService: RouterService) {
    this.responsiveOptions = [{
      breakpoint: '1024px',
      numVisible: 1,
      numScroll: 3
    }];
  }

  toRent() {
    this.routerService.toRent();
  }
  toRide() {
    this.routerService.toRideShare();
  }
  toTrip() {
    this.routerService.toTripDivision();
  }
 toContact(){
  this.routerService.toContact();
 }

  ngOnInit(): void {
    this.images = [
      { random: 'I have never rented from car TVF before but found the on line very clear about their cancellation policy, the $75. cancellation fee, and the credit card requirements at time of pick up.', picture: '../../assets/dashboardAssets/person_6.jpg' },
      { random: 'I am only rating the reservation process. I have not picked up the rental yet. The reservation process went smoothly. ', picture: '../../assets/dashboardAssets/person_7.jpg' },
      { random: 'The rates were moderate, driver was acceptable, and the general experience was additionally marvelous.', picture: '../../assets/dashboardAssets/person_5.jpg' },
      { random: 'Car on rentals provides us very good service that they helped us to reach out the destination without any problem and also without stress.', picture: '../../assets/dashboardAssets/person_1.jpg' },

      { random: 'This site saved me over $220 on same type vehicle at same rental agency... booking was very quick & straightforward... will certainly use this site to compare for future travel... ', picture: '../../assets/dashboardAssets/person_3.jpg' },
      { random: 'Good price compare to other agencies. Excellent customer support. I misspelled my email address, so I called them. The guy answered my phone, looked for and corrected it. Finally I got the reservation letter.', picture: '../../assets/dashboardAssets/person_2.jpg' },

    ];
  }
}
