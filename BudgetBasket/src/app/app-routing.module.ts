import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './not-found/not-found.component'
import { HomepageComponent } from './store/homepage/homepage.component';
import { IndiStorePageComponent } from './store/indi-store-page/indi-store-page.component';
import { SearchResultComponent } from './store/search-result/search-result.component';
import { LogInComponent } from './user-management/log-in/log-in.component';
import { SignUpComponent } from './user-management/sign-up/sign-up.component';
import { OrderModelComponent } from './finmanager/order/order.component';
import { BillScanComponent } from './finmanager/bill-scan/bill-scan.component'
import { DashboardComponent } from './finmanager/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', component: LogInComponent },
  { path: 'login', component: LogInComponent },
  { path: 'signin', component: LogInComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'store', component: HomepageComponent },
  { path: 'istore', component: IndiStorePageComponent },
  { path: 'searchresult/:searchKeyword', component: SearchResultComponent },
  { path: 'order', component: OrderModelComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'bill-scan', component: BillScanComponent },
  { path: '**', pathMatch: 'full', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
