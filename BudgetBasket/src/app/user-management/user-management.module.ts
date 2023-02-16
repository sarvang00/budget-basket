import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';

import { SignInComponent } from './sign-in/sign-in.component';
import { SignOutComponent } from './sign-out/sign-out.component';

@NgModule({
  declarations: [SignInComponent, SignOutComponent],
  imports: [
    CommonModule,
    UserManagementRoutingModule
  ],
  providers: [],
  bootstrap: [SignInComponent, SignOutComponent]
})
export class UserManagementModule { }
