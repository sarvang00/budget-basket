import { Component } from '@angular/core';
import { User } from '../model/User';
import { v4 as uuidv4 } from 'uuid';
import { UserManagementService } from '../services/user-management.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  userFirstName!: string;
  userLastName!: string;
  userEmail!: string;
  userPassword!: string;

  constructor(private userService: UserManagementService, private router: Router) {}

  ngOnInit(): void {}

  handleSignUp() {
    const newUser: User = {
      id: uuidv4(),
      name: this.userFirstName+" "+this.userLastName,
      email: this.userEmail,
      password: this.userPassword,
    };
    this.userService.signUpUser(newUser);

    // to be deleted
    console.log(this.userService.getUsers());

    this.userFirstName="";
    this.userLastName="";
    this.userEmail="";
    this.userPassword="";
    this.router.navigate(['/login']);
  }

}
