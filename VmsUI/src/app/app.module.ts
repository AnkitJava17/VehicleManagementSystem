import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatError, MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { AdminComponent } from './components/admin/admin.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';

import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { MyBookingsComponent } from './components/my-bookings/my-bookings.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RideSharingComponent } from './components/ride-sharing/ride-sharing.component';
import { VehicleRentalComponent } from './components/vehicle-rental/vehicle-rental.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { RideShareCarsComponent } from './components/ride-share-cars/ride-share-cars.component';
import {MatExpansionModule} from '@angular/material/expansion';

import { MatList, MatListModule } from '@angular/material/list';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { AdminRideShareComponent } from './components/admin-ride-share/admin-ride-share.component';

import { MatSidenavModule } from '@angular/material/sidenav';
// import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
// import { ModalModule } from 'mdb-angular-ui-kit/modal';

import { MatSelectModule } from '@angular/material/select';
import { CarouselModule } from 'primeng/carousel';
import { RentBikeComponent } from './components/rent-bike/rent-bike.component';
import { RentCarsComponent } from './components/rent-cars/rent-cars.component';
import { DashBoardComponent } from './components/dash-board/dash-board.component';

import { DashServicesComponent } from './components/dash-services/dash-services.component';
import { RideDetailsComponent } from './components/ride-details/ride-details.component';
import { BookedComponent } from './components/booked/booked.component';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { RegisterComponent } from './components/register/register.component';
import { AdminRentalComponent } from './components/admin-rental/admin-rental.component';
import { AdminShareComponent } from './components/admin-share/admin-share.component';
import { AdminTripComponent } from './components/admin-trip/admin-trip.component';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from 'ngx-ui-loader';
import { TripDivisionComponent } from './components/trip-division/trip-division.component';
import { TripDivisionDisplayComponent } from './components/trip-division-display/trip-division-display.component';
import { TripDivisionFormComponent } from './components/trip-division-form/trip-division-form.component';


@NgModule({
  declarations: [
    AppComponent,
    AboutUsComponent,
    ContactUsComponent,
    FooterComponent,
    HeaderComponent,
    LoginComponent,
    MyBookingsComponent,
    ProfileComponent,
    RideSharingComponent,
    TripDivisionComponent,
    TripDivisionDisplayComponent,
    VehicleRentalComponent,
    AdminComponent,
    RideShareCarsComponent,
    AdminRideShareComponent,
    RentBikeComponent,
    RentCarsComponent,
    DashBoardComponent,
    RideSharingComponent,
    RideShareCarsComponent,
    RegisterComponent,
    DashServicesComponent,
    RideDetailsComponent,
    BookedComponent,
    AdminRentalComponent,
    AdminShareComponent,
    AdminTripComponent,
    TripDivisionFormComponent,
    TripDivisionDisplayComponent
  ],
  imports: [
    BrowserModule,
    MatListModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTabsModule,
    MatButtonModule,
    MatIconModule,
    MatDatepickerModule,
    MatMenuModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatCardModule,
    MatDialogModule,
    MatSnackBarModule,
    MatGridListModule,
    MatExpansionModule,
    MatListModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatSelectModule,
    CarouselModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule,
    NgxUiLoaderModule,
    NgxUiLoaderHttpModule
  ],
  providers: [
    AuthService,
    

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
