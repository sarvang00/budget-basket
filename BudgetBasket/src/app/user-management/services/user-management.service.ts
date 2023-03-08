import { HttpClient } from '@angular/common/http';
import { NONE_TYPE } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';

import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  private authUser!: User;
  constructor(private httpClient : HttpClient) {
  }

  signUpUser(user: User) {
    this.httpClient.post('http://localhost:9090/user/registerUser', user).subscribe(data => console.log(data));
  }

  signInUser(userCredentials: any) {
    this.httpClient.post<User>('http://localhost:9090/user/loginValidate', userCredentials).subscribe(data => {this.authUser=data});
  }
}
