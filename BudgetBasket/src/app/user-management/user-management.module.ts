import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';

import { SignInComponent } from './signin.component';
import { SignOutComponent } from './signout.component';

@NgModule({
  declarations: [SignInComponent, SignOutComponent],
  imports: [
    CommonModule,
    UserManagementRoutingModule
  ],
  exports: [SignInComponent, SignOutComponent],
  providers: [],
  bootstrap: [SignInComponent, SignOutComponent]
})
export class UserManagementModule { }
