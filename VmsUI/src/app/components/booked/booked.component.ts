import { Component } from '@angular/core';

@Component({
  selector: 'app-booked',
  templateUrl: './booked.component.html',
  styleUrls: ['./booked.component.css']
})
export class BookedComponent {
  randomNumber: number | undefined;

  constructor(){
    this.generateRandomNumber();
  }

  getRandomNumber(min: number, max: number): number {
    // Calculate the range of possible values
    const range = max - min + 1;

    // Generate a random number within the range and add the minimum value
    const randomNumber = Math.floor(Math.random() * range) + min;

    return randomNumber;

  }
  generateRandomNumber() {
    const minNumber = 100087;
    const maxNumber = 400099;
    this.randomNumber = this.getRandomNumber(minNumber, maxNumber);
  }
}
