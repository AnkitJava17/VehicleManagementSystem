import { Component } from '@angular/core';
import { RouterService } from 'app/services/router.service';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent {
  constructor(private routerService: RouterService) { }
  toLogin() {
    this.routerService.toLogin();
  }

}
