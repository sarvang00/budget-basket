import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StoreRoutingModule } from './store-routing.module';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [
    HomepageComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    StoreRoutingModule
  ]
})
export class StoreModule { }
