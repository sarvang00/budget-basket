import { Component } from '@angular/core';
import * as Tesseract from 'tesseract.js';
import { Router } from '@angular/router';
import { FinManagerService } from '../services/fin-manager.service';
import { CategoryService } from '../services/category.service';
import { Order } from '../model/Order';
import { User } from 'src/app/user-management/model/User';
import { UserManagementService } from 'src/app/services/user-management.service';


@Component({
  selector: 'app-bill-scan',
  templateUrl: './bill-scan.component.html',
  styleUrls: ['./bill-scan.component.css']
})
export class BillScanComponent {

  myAuthUser!: User;

  imageSrc!: string;
  fileName = '';

  products: Order[] = [];
  items: string[] = [];
  prices: string[] = [];
  showData = false;
  scanningData = false;

  categories: any = [];

  
  billOrders: any = [];

  constructor(private finManagerService: FinManagerService, private router: Router, private categoryService: CategoryService, private userService: UserManagementService) {
    this.myAuthUser = userService.getAuthUser();
    categoryService.getCategories().subscribe({
      next: value => this.categories = value,
    });
  }


  onFileSelected(event: any): void {
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.imageSrc = reader.result as string;
    };
  }

  async onUpload(): Promise<void> {
    this.scanningData = true;
    const result = await Tesseract.recognize(this.imageSrc);
    this.imageSrc = "";

    const result_line = result.data.lines[0];
    const all_product = [];
    let upper_details = 0;

    for (let i = 0; i < result.data.lines.length; i++) {
      const result_line = result.data.lines[i];
      if (result_line.words[0].text == "STH") {
        upper_details = i;
        break;
      }

    }

    let lower_details = 0;
    for (let i = upper_details + 1; i < result.data.lines.length; i++) {
      const result_line = result.data.lines[i];

      if (result_line.words[0].text == "SUBTOTAL") {
        lower_details = i;
        break;
      }

    }


    for (let i = upper_details + 1; i < lower_details; i++) {

      const result_line = result.data.lines[i];
      const total_words = result_line.words.length;
      const product_code = result_line.words[total_words - 3].text;

      let product_name = "";
      for (let j = 0; j < total_words - 3; j++) {
        product_name = product_name + result_line.words[j].text + " ";

      }
      const product_price = result_line.words[total_words - 1].text.replace(/(\r\n|\n|\r)/gm, "");
      const quantity = result_line.words[total_words - 2].text.replace(/(\r\n|\n|\r)/gm, "");
      var product: Order = {
        productName: product_name,
        productPrice: parseFloat(product_price.slice(1)),
        purchaseDate: new Date(),
        productCategory: this.categories[24].categoryName,
        productQuantity: 1, 
        userEmail: this.myAuthUser.email, 
        expiryDate: new Date()
      };
      this.products.push(product);

    }
    this.showData = true;
  }

  onBillSubmit() {
    this.finManagerService.addBillOrders(this.products);
    this.router.navigate(['/dashboard']);
  }
}
