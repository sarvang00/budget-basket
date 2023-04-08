import { HttpClient } from '@angular/common/http';
import { NONE_TYPE } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, tap } from 'rxjs';

import { User } from '../user-management/model/User';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  private authUser: any;
  private authUserSubject: BehaviorSubject<any> = new BehaviorSubject(null);
  public publicIP: String = "34.152.13.63";
  
  constructor(private httpClient : HttpClient) {
  }

  signUpUser(user: User) {
    this.httpClient.post('http://'+this.publicIP+':9090/user/registerUser', user).subscribe();
  }

  signInUser(userCredentials: any): Observable<any> {
    return this.httpClient.post<User>('http://'+this.publicIP+':9090/user/loginValidate', userCredentials).pipe(
      tap((user: any) => {
        if(user) {
          this.authUser = user;
          this.authUserSubject.next(this.authUser);
          this.setCurrentUser(user);
        }
    }));
  }

  signOutUser() {
    localStorage.removeItem("currentUser");
  }

  getAuthUser() {
    return JSON.parse(localStorage.getItem("currentUser") || '{}');
  }

  setCurrentUser(user: any) {
    localStorage.setItem("currentUser", JSON.stringify(user));
  }
}
