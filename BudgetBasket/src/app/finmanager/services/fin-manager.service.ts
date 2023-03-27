import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';

import { OrderComponent } from '../model/Order';

@Injectable({
  providedIn: 'root'
})
export class FinManagerService {
  public ordersSubject: BehaviorSubject<any> = new BehaviorSubject(null);

  constructor(private httpClient : HttpClient) {}

   addOrder(orderDetails: OrderComponent){
      // console.log("hit to backedn");
      // console.log(orderDetails);
      // console.log("dbdbdbdb dbdb");
      this.httpClient.post('http://localhost:9090/inventory/saveProductsInInventory', orderDetails).subscribe();
   }

   getOrders(userEmail: String): Observable<any>  {
    var userProductsUrl = "http://localhost:9090/inventory/getInventory?user="+userEmail;
    return this.httpClient.get(userProductsUrl).pipe(tap((orderResults: any) => {
      this.ordersSubject.next(orderResults);
    }));
   }
}
