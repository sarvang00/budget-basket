import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './signin.component';
import { SignOutComponent } from './signout.component';

const routes: Routes = [
  { path: 'signin', component: SignInComponent },
  { path: 'signout', component: SignOutComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
