import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FinmanagerRoutingModule } from './finmanager-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { OrderModelComponent } from './order/order.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';


@NgModule({
  declarations: [
    DashboardComponent,
    OrderModelComponent,
    NavbarComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    FinmanagerRoutingModule,
    FormsModule
  ]
})
export class FinmanagerModule { }
