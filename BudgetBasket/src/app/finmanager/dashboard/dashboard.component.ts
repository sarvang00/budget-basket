import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserManagementService } from 'src/app/services/user-management.service';
import { User } from 'src/app/user-management/model/User';
import { FinManagerService } from '../services/fin-manager.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  myAuthUser!: User;
  public userOrders!: any;
  public expiringToday!: any;

  constructor(private userService: UserManagementService, private finManagerService: FinManagerService, private router: Router) {
    this.myAuthUser = userService.getAuthUser();
    this.finManagerService.getOrders(this.myAuthUser.email).subscribe((userOrders) => this.userOrders=userOrders);
    this.finManagerService.getExpiringToday(this.myAuthUser.email).subscribe((expiringToday) => this.expiringToday=expiringToday);
  }

  addManualOrder() {
    this.router.navigate(['/order']);
  }

  goToBillScanner() {
    this.router.navigate(['/bill-scan']);
  }
  
}
