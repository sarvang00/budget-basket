import { Component } from '@angular/core';
import { User } from '../model/User';
import { UserAddress } from '../model/UserAddress';
import { v4 as uuidv4 } from 'uuid';
import { UserManagementService } from '../../services/user-management.service';
import { Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  userFirstName!: string;
  userLastName!: string;
  userEmail!: string;
  userPassword!: string;
  phoneNumber!: string;
  addressLine1!: string;
  addressLine2!: string;
  addressCity!: string;
  addressPostalCode!: string;
  addressCountry!: string;

  regexValidations = {
  emailValidation: '/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/',
    phoneValidation: '^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$'
  };



  constructor(private userService: UserManagementService, private router: Router) {}

  ngOnInit(): void {}




  handleSignUp() {
    const userAddress: UserAddress = {
      addressLine1: this.addressLine1,
      addressLine2: this.addressLine2,
      addressCity: this.addressCity,
      addressPostalCode: this.addressPostalCode,
      addressCountry: this.addressCountry,
      addressContactNumber: this.phoneNumber,
  }

    const newUser: User = {
      firstName: this.userFirstName,
      lastName: this.userLastName,
      email: this.userEmail,
      password: this.userPassword,
      phoneNumber: this.phoneNumber,
      createdAt: new Date(),
      updatedAt: new Date(),
      userAddress: userAddress,
    };
    this.userService.signUpUser(newUser);

    this.userFirstName="";
    this.userLastName="";
    this.userEmail="";
    this.userPassword="";
    this.phoneNumber="";
    this.addressLine1="";
    this.addressLine2="";
    this.addressCity="";
    this.addressPostalCode="";
    this.addressCountry="";
    this.router.navigate(['/login']);
  }

}
