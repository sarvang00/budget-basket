import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FinManagerService } from '../services/fin-manager.service';
import { OrderComponent } from '../model/Order';
import { v4 as uuidv4 } from 'uuid';



@Component({
  selector: 'order-detail',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderModelComponent {

  orderDate!: Date;
  productName!: string;
  category!: string;
  quantity!: number;
  actualPrice!: number;
  discountPrice!: number;

  constructor(private FinManagerService: FinManagerService, private router: Router) {}

  ngOnInit(): void {}

  handleOrder() {

    console.log("I am reached")
    const order: OrderComponent = {
      orderDate: this.orderDate,
      productName: this.productName,
      category: this.category,
      quantity: this.quantity,
      actualPrice: this.actualPrice,
      discountPrice: this.discountPrice,
    };

    
    
    this.FinManagerService.addOrder(order);
  }
}
