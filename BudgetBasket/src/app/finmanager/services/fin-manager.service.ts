import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { OrderComponent } from '../model/Order';

@Injectable({
  providedIn: 'root'
})
export class FinManagerService {

  constructor(private httpClient : HttpClient) {
}

   addOrder(orderDetails: OrderComponent){
      // console.log("hit to backedn");
      // console.log(orderDetails);
      // console.log("dbdbdbdb dbdb");
      this.httpClient.post('http://localhost:9090/inventory/saveProductsInInventory', orderDetails).subscribe(data => console.log(data));

   }
}
