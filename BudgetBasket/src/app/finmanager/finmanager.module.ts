import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FinmanagerRoutingModule } from './finmanager-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { OrderModelComponent } from './order/order.component';
import { BillScanComponent } from './bill-scan/bill-scan.component';


@NgModule({
  declarations: [
    DashboardComponent,
    OrderModelComponent,
    BillScanComponent
  ],
  imports: [
    CommonModule,
    FinmanagerRoutingModule,
    FormsModule
  ]
})
export class FinmanagerModule { }
