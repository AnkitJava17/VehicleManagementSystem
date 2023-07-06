import { Component } from '@angular/core';
import { RouterService } from 'app/services/router.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  constructor(private routerService: RouterService) { }

  toAboutUs() {
    this.routerService.toAboutUs();
  }
}
