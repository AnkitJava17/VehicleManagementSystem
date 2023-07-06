import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './config';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public loginStatusSubject = new Subject<boolean>();

  constructor(private httpClient: HttpClient) {

   }


  //current user: which is loggedin
  public getCurrentUser() {
    return this.httpClient.get(`${environment.apiGatewayBaseUrl}/api/v1/users/current-user`);
  }

  //generate token
  public generateToken(loginData: any) {
    //return this.http.post(`${baseUrl}/generate-token`, loginData);
    console.log(loginData);
    return this.httpClient.post(`${environment.apiGatewayBaseUrl}/user/login`, loginData);
  }
  //login user: set token in localStorage
  public loginUser(token: any) {
    localStorage.setItem('bearerToken', token);

    return true;
  }

  //isLogin: user is logged in or not
  public isLoggedIn() {
    let tokenStr = localStorage.getItem('bearerToken');
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    } else {
      return true;
    }
  }

  // logout : remove token from local storage
  public logout() {
    localStorage.removeItem('bearerToken');
    localStorage.removeItem('user');
    return true;
  }

  //get token
  public getToken() {
    return localStorage.getItem('bearerToken');
  }

  //set userDetail
  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  //getUser
  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  //get user role

  public getUserRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}