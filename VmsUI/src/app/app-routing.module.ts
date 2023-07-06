import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';

import { LoginComponent } from './components/login/login.component';
import { MyBookingsComponent } from './components/my-bookings/my-bookings.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RideSharingComponent } from './components/ride-sharing/ride-sharing.component';
import { VehicleRentalComponent } from './components/vehicle-rental/vehicle-rental.component';
import { AdminComponent } from './components/admin/admin.component';

import { FooterComponent } from './components/footer/footer.component';
import { AdminRideShareComponent } from './components/admin-ride-share/admin-ride-share.component';

import { DashBoardComponent } from './components/dash-board/dash-board.component';
import { DashServicesComponent } from './components/dash-services/dash-services.component';
import { RideDetailsComponent } from './components/ride-details/ride-details.component';
import { RentCarsComponent } from './components/rent-cars/rent-cars.component';
import { BookedComponent } from './components/booked/booked.component';
import { RegisterComponent } from './components/register/register.component';
import { TripDivisionComponent } from './components/trip-division/trip-division.component';
import { TripDivisionFormComponent } from './components/trip-division-form/trip-division-form.component';
import { TripDivisionDisplayComponent } from './components/trip-division-display/trip-division-display.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'dash-board' },
  { path: 'about-us', component: AboutUsComponent },
  { path: 'contact-us', component: ContactUsComponent },
  { path: 'rent-cars', component: RentCarsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'my-bookings', component: MyBookingsComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'ride-sharing', component: RideSharingComponent},
  { path: 'trip-division', component: TripDivisionComponent },
  { path: 'trip-division-form', component:TripDivisionFormComponent},
  { path: 'trip-division-display', component: TripDivisionDisplayComponent},
  { path: 'admin', component: AdminComponent },
  { path: 'rent', component: VehicleRentalComponent},
  { path: 'admin-ride-share', component: AdminRideShareComponent },
  { path: 'dash-services', component: DashServicesComponent },
  { path: 'dash-board', component: DashBoardComponent },
  { path: 'ride-details', component: RideDetailsComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'booked', component: BookedComponent },
  { path: 'register', component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],

})

export class AppRoutingModule { }
