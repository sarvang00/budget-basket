import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';

import { Order } from '../model/Order';

@Injectable({
  providedIn: 'root'
})
export class FinManagerService {
  public ordersSubject: BehaviorSubject<any> = new BehaviorSubject(null);
  public publicIP: String = "34.152.13.63";

  constructor(private httpClient : HttpClient) {}

   addOrder(orderDetails: Order){
      this.httpClient.post('http://'+this.publicIP+':9090/inventory/saveProductsInInventory', orderDetails).subscribe();
   }

   getOrders(userEmail: String): Observable<any>  {
    var userProductsUrl = "http://"+this.publicIP+":9090/inventory/getInventory?user="+userEmail;
    return this.httpClient.get(userProductsUrl).pipe(tap((orderResults: any) => {
      this.ordersSubject.next(orderResults);
    }));
   }

   getExpiringToday(userEmail: String): Observable<any>  {
    var expiringToday = "http://"+this.publicIP+":9090/inventory/getExpiryInventory?user="+userEmail;
    return this.httpClient.get(expiringToday).pipe(tap((expiringResults: any) => {
      this.ordersSubject.next(expiringResults);
    }));    
   }

   addBillOrders(billOrders: Order[]) {
    this.httpClient.post('http://'+this.publicIP+':9090/inventory/saveScannedProductsInInventory', billOrders).subscribe();
   }
}
