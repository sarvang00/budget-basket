import { NgModule, isDevMode } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FinmanagerRoutingModule } from './finmanager-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OrderModelComponent } from './order/order.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { BillScanComponent } from './bill-scan/bill-scan.component';
import { ServiceWorkerModule } from '@angular/service-worker';

@NgModule({
  declarations: [
    DashboardComponent,
    OrderModelComponent,
    NavbarComponent,
    SidebarComponent,
    BillScanComponent
  ],
  imports: [
    CommonModule,
    FinmanagerRoutingModule,
    FormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: true })
  ]
})
export class FinmanagerModule { }
