import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserManagementRoutingModule } from './user-management-routing.module';

import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

@NgModule({
  declarations: [SignInComponent, SignUpComponent, ForgotPasswordComponent],
  imports: [
    CommonModule,
    UserManagementRoutingModule
  ],
  providers: [],
  bootstrap: [SignInComponent]
})
export class UserManagementModule { }
