import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IstoreService } from 'src/app/services/istore.service';

@Component({
  selector: 'app-indi-store-page',
  templateUrl: './indi-store-page.component.html',
  styleUrls: ['./indi-store-page.component.css']
})
export class IndiStorePageComponent {
  storeName!: String;
  public storeData!: any;
  constructor(private storeService: IstoreService, private router: Router) {
    this.storeName = this.storeService.storeName;
    if (this.storeService.storeName==='Kroger') {
      this.storeService.getKrogerProducts().subscribe((storeData) => this.storeData=storeData);
    } else if (this.storeService.storeName==='Aide') {
      this.storeService.getAideProducts().subscribe((storeData) => this.storeData=storeData);
    } else if (this.storeService.storeName==='Trader Joe\'s') {
      this.storeService.getTraderJoeProducts().subscribe((storeData) => this.storeData=storeData);
    } else {
      alert("Error in processing store!");
      this.router.navigate(['/store']);
    }
    // console.log(this.storeData)
  }
}
