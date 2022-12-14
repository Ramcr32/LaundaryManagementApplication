import { ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { BookingComponent } from './booking/booking.component';
import { FormsModule  } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { UserTableComponent } from './user-table/user-table.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { LoaderComponent } from './loader/loader.component';
import { AuthInterceptorInterceptor } from './util/auth-interceptor.interceptor';
import { EmployeeTableComponent } from './employee-table/employee-table.component';
import { GlobalErrorHandlerInterceptor } from './util/global-error-handler.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    BookingComponent,
    UserComponent,
    UserTableComponent,
    UserUpdateComponent,
    BookingListComponent,
    LoaderComponent,
    EmployeeTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide :HTTP_INTERCEPTORS,
    useClass : AuthInterceptorInterceptor,
    multi : true
  },
  {
    provide: ErrorHandler,
    useClass :GlobalErrorHandlerInterceptor
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
