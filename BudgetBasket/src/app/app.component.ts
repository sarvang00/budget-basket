import { Component } from '@angular/core';
import { UserManagementService } from './services/user-management.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UserManagementService]
})
export class AppComponent {
  title = 'BudgetBasket';
}
