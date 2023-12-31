import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserManagementService } from 'src/app/services/user-management.service';
import { User } from 'src/app/user-management/model/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  myAuthUser!: User;

  constructor(private userService: UserManagementService, private router: Router) {
    this.myAuthUser = userService.getAuthUser();
  }

  ngOnInit() {
    if(!this.myAuthUser.firstName) {
      this.router.navigate(['/login']);
    }
  }

  logOut() {
    this.userService.signOutUser();
    this.router.navigate(['/']);
  }
}
