import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'

import { StoreRoutingModule } from './store-routing.module';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { IndiStorePageComponent } from './indi-store-page/indi-store-page.component';
import { SearchResultComponent } from './search-result/search-result.component';


@NgModule({
  declarations: [
    HomepageComponent,
    NavbarComponent,
    IndiStorePageComponent,
    SearchResultComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    StoreRoutingModule
  ]
})
export class StoreModule { }
