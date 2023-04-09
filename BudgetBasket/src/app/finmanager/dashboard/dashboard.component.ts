import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserManagementService } from 'src/app/services/user-management.service';
import { User } from 'src/app/user-management/model/User';
import { FinManagerService } from '../services/fin-manager.service';
import { SwPush } from '@angular/service-worker'
import { Subject } from 'rxjs';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  private notificationSubject = new Subject<object>();
  myAuthUser!: User;
  public userOrders!: any;
  public expiringToday!: any;

  constructor(private userService: UserManagementService, private finManagerService: FinManagerService, private router: Router, private notificationService: NotificationService, private swPush: SwPush) {
    this.myAuthUser = userService.getAuthUser();
    this.finManagerService.getOrders(this.myAuthUser.email).subscribe((userOrders) => this.userOrders=userOrders);
    this.finManagerService.getExpiringToday(this.myAuthUser.email).subscribe((expiringToday) => this.expiringToday=expiringToday);
  }

  ngOnInit() {
    if (this.swPush.isEnabled) { // Check if push notifications are enabled
      this.swPush.requestSubscription({ serverPublicKey: "environment.VAPID_PUBLIC_KEY" })
        .then(subscription => {
          // Send the subscription to the server to store it
          console.log('Subscription successful', subscription);
        })
        .catch(error => {
          console.error('Error occurred while requesting subscription', error);
        });
    }
    this.notificationService.getNotificationObservable().subscribe(notification => console.log('Received notification', notification));
  }

  addManualOrder() {
    this.router.navigate(['/order']);
  }

  goToBillScanner() {
    this.router.navigate(['/bill-scan']);
  }

  sendNotification() {
    // this._notifications.show('My Title', {body: 'This is my notification.'});
    this.notificationService.sendNotification();
  }
  
}
