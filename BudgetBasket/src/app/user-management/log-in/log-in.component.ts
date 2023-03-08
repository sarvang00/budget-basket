import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserManagementService } from '../services/user-management.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent {
  username!: string;
  password!: string;

  constructor(private userService: UserManagementService, private router: Router) {}

  handleLogIn() {
    
    const userCreds = {
      "email": this.username,
      "password": this.password
    }

    this.userService.signInUser(userCreds);

    this.username="";
    this.password="";
    
    this.router.navigate(['/']);
  }
}
