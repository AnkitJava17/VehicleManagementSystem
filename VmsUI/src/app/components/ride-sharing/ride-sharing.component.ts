/// <reference types="@types/googlemaps" />




import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { DatePipe } from '@angular/common';

import { RouterService } from 'app/services/router.service';

import { Car } from '../ride-share-cars/car';

import { ShareCarService } from 'app/services/share-car.service';
import { RentCars } from '../rent-cars/rentCar';
import { Router } from '@angular/router';
import { Rides } from './rides';
import { MapServiceService } from 'app/services/map-service.service';




declare const google: any;

declare global {

    interface Window {

        initializeMap: () => void;

    }

}




@Component({

    selector: 'app-ride-sharing',

    templateUrl: './ride-sharing.component.html',

    styleUrls: ['./ride-sharing.component.css'],

})

export class RideSharingComponent implements OnInit {

    searchResult: Car[] = [];

    source: string = '';

    destination: string = '';

    date: Date = new Date();

    passengers: number = 0;

    availableCars: Car[];
    minDate: Date;
    carImages: string[] = [];
    map: any;
    directionsService: any;
    directionsDisplay: any;
    constructor(private http: HttpClient,private maps:MapServiceService, public routeService: RouterService, private shareService: ShareCarService, private route: Router) {
        this.availableCars = [];
        this.source = '';
        this.destination = '';
        this.minDate = new Date();
    }

    searchRide() {
        this.calcRoute();
    }

    toRideDetails() {
        this.routeService.toRideDetails();
    }
    ngOnInit(): void {

        window.initializeMap = () => {

            const myLatLng = { lat: 18.5204, lng: 73.8567 };

            const mapOptions = {

                center: myLatLng,

                zoom: 7,

                mapTypeId: google.maps.MapTypeId.ROADMAP,

            };

            this.map = new google.maps.Map(
                document.getElementById('googleMap'),
                mapOptions
            );
            this.directionsService = new google.maps.DirectionsService();
            this.directionsDisplay = new google.maps.DirectionsRenderer();
            const input1 = document.getElementById('source') as HTMLInputElement;

            const src = new google.maps.places.Autocomplete(input1);
            const input2 = document.getElementById('destination') as HTMLInputElement;
            const dist = new google.maps.places.Autocomplete(input2);
            google.maps.event.addListener(src, 'place_changed', () => {

                this.source = src.getPlace().name;

                const latSrc = src.getPlace().geometry.location.lat();

                const longSrc = src.getPlace().geometry.location.lng();

            });




            google.maps.event.addListener(dist, 'place_changed', () => {

                this.destination = dist.getPlace().name;

                const latDest = dist.getPlace().geometry.location.lat();

                const longDest = dist.getPlace().geometry.location.lng();

            });
            const request = {

                origin: this.source,

                destination: this.destination,

                travelMode: google.maps.TravelMode.DRIVING,

                unitSystem: google.maps.UnitSystem.IMPERIAL,

            };
            this.directionsService.route(request, (result: any, status: any) => {
                if (status == google.maps.DirectionsStatus.OK) {
                    const output = document.getElementById('output');
                    if (output != null) {
                        output.innerHTML =
                            "<div class='alert-info'>From: " +
                            this.source +
                            '.<br />To: ' +
                            this.destination +
                            ".<br /> Driving distance <i class='fas fa-road'></i> : " +
                            result.routes[0].legs[0].distance.text +
                            ".<br />Duration <i class='fas fa-hourglass-start'></i> : " +
                            result.routes[0].legs[0].duration.text +
                            '.</div>';
                    }
                    this.directionsDisplay.setDirections(result);
                } else {
                    this.directionsDisplay.setDirections({ routes: [] });
                    const output = document.getElementById('output');
                    if (output != null) {
                        output.innerHTML =
                            "<div class='alert-danger'><i class='fas fa-exclamation-triangle'></i> Could not retrieve driving distance.</div>";
                    }
                }
            });
            this.directionsDisplay.setMap(this.map);
        };
        const script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = `https://maps.googleapis.com/maps/api/js?key=AIzaSyCx4VpvSh6mgFuyRbGGjoPUV9973fUqW6o&libraries=places&callback=initializeMap`;
        document.body.appendChild(script);
    }
    calcRoute(): void {
        console.log(this.destination);
        console.log(this.passengers);
        this.shareService.getAvailableCars(this.destination, this.passengers).subscribe(
            (cars: Car[]) => {
                this.availableCars = cars;
                // this.carImages = cars.map((car: Rides) => car.carImage);
            }
        );
        console.log(this.availableCars);
        const request = {
            origin: this.source,
            destination: this.destination,
            travelMode: google.maps.TravelMode.DRIVING,
            unitSystem: google.maps.UnitSystem.IMPERIAL,
        };
        this.directionsService.route(request, (result: any, status: any) => {
            if (status == google.maps.DirectionsStatus.OK) {
                const output = document.getElementById('output');
                if (output != null) {
                    output.innerHTML =
                        "<div class='alert-info'>From: " +
                        this.source +
                        '.<br />To: ' +
                        this.destination +
                        ".<br /> Driving distance <i class='fas fa-road'></i> : " +
                        result.routes[0].legs[0].distance.text +
                        ".<br />Duration <i class='fas fa-hourglass-start'></i> : " +
                        result.routes[0].legs[0].duration.text +
                        '.</div>';
                }
                this.directionsDisplay.setDirections(result);
            } else {
                this.directionsDisplay.setDirections({ routes: [] });
                const output = document.getElementById('output');
                if (output != null) {
                    output.innerHTML =
                        "<div class='alert-danger'><i class='fas fa-exclamation-triangle'></i> Could not retrieve driving distance.</div>";

                }

            }

        });

    }

    bookCar(car:Car) {

        alert("car booked");
        console.log('Booking car:', car);
        this.route.navigate(['booked']);
    }


}