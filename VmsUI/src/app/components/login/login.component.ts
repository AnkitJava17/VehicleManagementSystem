import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  // loginData = {
  //   username:'',
  //   password:'',
  // };

  loginForm: FormGroup;
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private httpClient: HttpClient,
    private loginService: LoginService
  ) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  //clearing the input fields
  clearInput() {
    this.loginForm.get('username')?.reset();
    this.loginForm.get('password')?.reset();
  }

  // redirectToRegister() {
  //   this.router.navigate(['/register']);
  // }

  ngOnInit(): void {}

  get loginFormControl() {
    return this.loginForm.controls;
  }

  onLogin() {
    const loginData = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
    };

    console.log('login button clicked');
    console.log(loginData);

    this.loginService.generateToken(loginData).subscribe(
      (data: any) => {
        console.log('success');
        console.log(data);
        // console.log(this.loginService.getUser());
        this.loginService.loginUser(data.token);

        this.loginService.getCurrentUser().subscribe((user: any) => {
          this.loginService.setUser(user);
          console.log(this.loginService.getUser());
          console.log(user);

          if (this.loginService.getUserRole() == 'ADMIN') {
            this.router.navigate(['admin']);
        this.loginService.loginStatusSubject.next(true);
          } else if (this.loginService.getUserRole() == 'NORMAL') {
            this.router.navigate(['dash-services']);
            this.loginService.loginStatusSubject.next(true);
          } else {
            this.router.navigate(['dash-board']);
            this.loginService.logout();
          }
        });

        if(this.loginForm.value.username == 'admin' && this.loginForm.value.password == 'admin'){
          this.router.navigate(['admin']);
          this.loginService.loginStatusSubject.next(true);
        }else{
          this.router.navigate(['dash-services']);
          this.loginService.loginStatusSubject.next(true);
        }

      },
      (error) => {
        console.log('Error !');
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'User does not exists!',
        });
      }
    );
  }
}
