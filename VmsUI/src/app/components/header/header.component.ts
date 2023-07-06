import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatMenuTrigger } from '@angular/material/menu';
import { LoginComponent } from '../login/login.component';
import { LoginService } from '../../services/login.service';
import { RouterService } from '../../services/router.service';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isDropdownOpen = false;

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  @ViewChild('menuTrigger')
  menuTrigger!: MatMenuTrigger;

  constructor(public dialog: MatDialog, private routerService: RouterService, private login: LoginService) { }

  openDialog() {
    const dialogRef = this.dialog.open(LoginComponent, {
      restoreFocus: false,
      backdropClass: "bdrop",
      autoFocus: false
    });
    dialogRef.afterClosed().subscribe(() => this.menuTrigger
      // .focus()
    );
  }
  toDashboard() {
    this.routerService.toDashboard();
  }
  toAboutUs() {
    this.routerService.toAboutUs();
  }
  toLogin() {
    this.routerService.toLogin();
  }
  toServices() {
    this.routerService.toServices();
  }
  toContact() {
    this.routerService.toContact();
  }


  isLoggedIn = false;
  user = null;


  ngOnInit(): void {
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe((data) => {
      this.isLoggedIn = this.login.isLoggedIn();
      this.user = this.login.getUser();
    });
  }

  async logout() {
    this.login.logout();
    window.location.reload();
    // this.login.loginStatusSubject.next(false);
  }
}
