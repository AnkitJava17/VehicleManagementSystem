import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'app/services/user.service';
import Swal from 'sweetalert2';
import { User } from './user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  userObj: User = new User();
  registerForm: FormGroup;

  constructor(
    private userService: UserService,
    private snack: MatSnackBar,
    private fb: FormBuilder,
    private router:Router
  ) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: [
        '',
        Validators.compose([
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
        ]),
      ],
    });
  }

  //getting the controls for the form
  get registerFormControl() {
    return this.registerForm.controls;
  }

  //clearing the input fields
  clearInput() {
    this.registerForm.get('username')?.reset();
    this.registerForm.get('password')?.reset();
    this.registerForm.get('firstName')?.reset();
    this.registerForm.get('lastName')?.reset();
    this.registerForm.get('email')?.reset();
    this.registerForm.get('phone')?.reset();
  }

  //to check password
  passwordValid(): boolean {
    const password = this.registerFormControl['password'].value;
    const hasUpperCase = /[A-Z]/.test(password);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
    const hasNumericChar = /\d/.test(password);

    return (
      password.length >= 8 && hasUpperCase && hasSpecialChar && hasNumericChar
    );
  }

  ngOnInit(): void {}

  onRegister() {
    this.userObj = this.registerForm.value;
    console.log(this.userObj);
    if (this.userObj.username == '' || this.userObj.username == null) {
      // alert('User is required !!');
      this.snack.open('Username is required !! ', '', {
        duration: 3000,
      });
      return;
    }

    if (this.userObj.password == '' || this.userObj.password == null) {
      // alert('User is required !!');
      this.snack.open('Password is required !! ', '', {
        duration: 3000,
      });
      return;
    }
    // if (this.registerForm.valid) {
    this.userService.addUser(this.userObj).subscribe(
      (data) => {
        // alert("Signup Successfull");
        Swal.fire('Registered Successfully! Please Login.');
        this.registerForm.reset();
        // this.router.navigate(['login']);
        console.log(data);
      },
      // (err) => Swal.fire('An error occurred! Please try again!')
      (err) =>
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong!',
        })
    );
    this.router.navigate(['login']);
  }
  // }
}
