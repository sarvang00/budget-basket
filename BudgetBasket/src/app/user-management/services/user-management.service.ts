import { NONE_TYPE } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';

import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {
  users!: User[];
  constructor() {
    this.users = [
      {
        id: "111",
        name: "aaa bbb",
        email: "qw@aw.ca",
        password: "hesoyam",
      },
      {
        id: "222",
        name: "bbb ccc",
        email: "we@aw.ca",
        password: "hesoyam",
      },
      {
        id: "333",
        name: "ccc ddd",
        email: "er@aw.ca",
        password: "hesoyam",
      }
    ]
  }

  getUsers() {
    return this.users;
  }

  signUpUser(user: User) {
    this.users.push(user);
  }

  removeUser(user: User) {
    const indexofTodo = this.users.findIndex(
      (currentObj) => currentObj.id === user.id,
    );
    this.users.splice(indexofTodo, 1);
  }
}
