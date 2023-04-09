import { Injectable } from '@angular/core';
import { SwPush } from '@angular/service-worker';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private notificationSubject = new Subject<object>();

  constructor(private swPush: SwPush) { }

  requestSubscription() {
    if (!this.swPush.isEnabled) {
      console.log('Service workers are not enabled');
      return;
    }
    Notification.requestPermission().then(permission => {
      if (permission === 'granted') {
        this.swPush.requestSubscription({
          serverPublicKey: '<your-public-key>'
        })
        .then(sub => console.log('Subscription successful'))
        .catch(err => console.error('Could not subscribe to notifications', err));
      }
    }).catch(err => console.error('Could not request permission', err));
  }

  sendNotification() {
    if ('serviceWorker' in navigator) {
      console.log('Service workers are supported');
    } else {
      console.log('Service workers are not supported');
    }
    if (!this.swPush.isEnabled) {
      console.log('Service workers are not enabled');
      return;
    }
    const message = {
      notification: {
        title: 'New notification',
        body: 'This is a test notification'
      }
    };
    this.notificationSubject.next(message);
  }

  getNotificationObservable() {
    return this.notificationSubject.asObservable();
  }
}
