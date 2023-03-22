import { Component } from '@angular/core';
import * as Tesseract from 'tesseract.js';
import { Router } from '@angular/router';
import { FinManagerService } from '../services/fin-manager.service';


@Component({
  selector: 'app-bill-scan',
  templateUrl: './bill-scan.component.html',
  styleUrls: ['./bill-scan.component.css']
})
export class BillScanComponent {

  imageSrc!: string;
  fileName = '';

  products : any =[];
  items: string[] = []; 
  prices: string[] = [];

  constructor(private FinManagerService: FinManagerService, private router: Router) {}

  onFileSelected(event:any): void {
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.imageSrc = reader.result as string;
    };
  }
  async onUpload(): Promise<void> {
    console.log("*****");
    const result = await Tesseract.recognize(this.imageSrc);
    console.log(result.data.lines);

    const result_line = result.data.lines[0];
    const all_product = [];
    let upper_details = 0;
    for (let i = 0; i < result.data.lines.length; i++) {
      const result_line = result.data.lines[i];
      
      if (result_line.words[0].text == "product") 
      {
        upper_details = i;
        break;
      }
    
    }
    console.log("upper_details",upper_details);
    for (let i = upper_details+1; i < result.data.lines.length; i++) {
      
      const result_line = result.data.lines[i];
      const total_words = result_line.words.length;
      console.log("line data : ",result_line);
      const product_code = result_line.words[0].text;
    
      let product_name = "";
      for (let j = 1; j < total_words-2; j++) {
        product_name = product_name + result_line.words[j].text + " ";
    
      }
      console.log("product name : ",product_name);
      const product_price = result_line.words[total_words-1].text.replace(/(\r\n|\n|\r)/gm, "");
      console.log("product price : ",product_price); // replace this with your desired operation on each element
      var product = {
        productID :product_code,
        productName:product_name,
        productPrice :product_price
      };
      this.products.push(product);
      
    }
    console.log(this.products);


  
  }

}
