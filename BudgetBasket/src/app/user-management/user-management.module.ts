import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'

import { UserManagementRoutingModule } from './user-management-routing.module';

import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [NavbarComponent, LogInComponent, SignUpComponent, ForgotPasswordComponent],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [LogInComponent]
})
export class UserManagementModule { }
