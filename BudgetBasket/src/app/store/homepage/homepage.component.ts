import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IstoreService } from 'src/app/services/istore.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
  constructor(private storeService: IstoreService, private router: Router) {}

  goToStore(storeName: string) {
    this.storeService.storeName = storeName;
    this.router.navigate(['/istore']);
  }
}
