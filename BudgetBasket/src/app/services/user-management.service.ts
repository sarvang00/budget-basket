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
  
  constructor(private httpClient : HttpClient) {
  }

  signUpUser(user: User) {
    this.httpClient.post('http://localhost:9090/user/registerUser', user).subscribe();
  }

  signInUser(userCredentials: any): Observable<any> {
    return this.httpClient.post<User>('http://localhost:9090/user/loginValidate', userCredentials).pipe(
      tap((user: any) => {
        if(user) {
          this.authUser = user;
          this.authUserSubject.next(this.authUser);
        }
    }));
  }

  signOutUser() {
    this.authUser = null;
  }

  getAuthUser(): Observable<any> {
    return this.authUserSubject.asObservable();
  }
}
