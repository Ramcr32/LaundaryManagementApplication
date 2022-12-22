import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { UserComponent } from './user/user.component';
import {HttpClientModule} from '@angular/common/http';
import { AddressComponent } from './address/address.component';
import { UserTableComponent } from './user-table/user-table.component';
import { BookingComponent } from './booking/booking.component';
import { LoginComponent } from './login/login.component';
import { AfterLogedInComponent } from './after-loged-in/after-loged-in.component';
import { NavbarComponent } from './navbar/navbar.component'
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddressComponent,
    UserTableComponent,
    BookingComponent,
    LoginComponent,
    AfterLogedInComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
