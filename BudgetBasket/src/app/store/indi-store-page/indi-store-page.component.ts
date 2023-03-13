import { Component } from '@angular/core';
import { IstoreService } from 'src/app/services/istore.service';

@Component({
  selector: 'app-indi-store-page',
  templateUrl: './indi-store-page.component.html',
  styleUrls: ['./indi-store-page.component.css']
})
export class IndiStorePageComponent {
  storeName!: String;
  public storeData!: any;
  constructor(private storeService: IstoreService) {
    this.storeName = this.storeService.storeName;
    this.storeService.getKrogerProducts().subscribe((storeData) => this.storeData=storeData);
    console.log(this.storeData)
  }
}
