import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FinmanagerModule } from './finmanager/finmanager.module';
import { StoreModule } from './store/store.module';

import { UserManagementModule } from './user-management/user-management.module';
import { FooterComponent } from './footer/footer.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserManagementModule,
    StoreModule,
    FinmanagerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }