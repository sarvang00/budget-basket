import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FinManagerService } from '../services/fin-manager.service';
import { Order } from '../model/Order';
import { User } from 'src/app/user-management/model/User';
import { UserManagementService } from 'src/app/services/user-management.service';



@Component({
  selector: 'order-detail',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderModelComponent {

  myAuthUser!: User;

  purchaseDate!: Date;
  productName!: string;
  productCategory!: string;
  productQuantity!: number;
  productPrice!: number;
  userId!: number;
  expiryDate!: Date;

  constructor(private userService: UserManagementService, private finManagerService: FinManagerService, private router: Router) {
    this.myAuthUser = userService.getAuthUser();
  }

  ngOnInit(): void {
    this.productCategory=""
  }

  handleOrder() {

    // console.log("I am reached")
    
    const order: Order = {
      purchaseDate: this.purchaseDate,
      productName: this.productName,
      productCategory: this.productCategory,
      productQuantity: this.productQuantity,
      productPrice: this.productPrice,
      userEmail: this.myAuthUser.email,
      expiryDate: new Date(this.purchaseDate)
    };

    // console.log(order);
    
    this.finManagerService.addOrder(order);
    this.router.navigate(['/dashboard']);
  }

  scanBill(){
    this.router.navigate(['/bill-scan']);
  }
}
