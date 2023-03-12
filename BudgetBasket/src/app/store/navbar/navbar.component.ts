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
  myAuthUser: any;
  constructor(private userService: UserManagementService, private router: Router) {
    userService.getAuthUser().subscribe((user) => {
      this.myAuthUser = user;
    });
  }

  ngOnInit(): void {
    if(this.myAuthUser==null) {
      this.router.navigate(['/']);
    }
  }
}
