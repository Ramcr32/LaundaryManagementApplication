import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingListComponent } from './booking-list/booking-list.component';
import { BookingComponent } from './booking/booking.component';
import { EmployeeTableComponent } from './employee-table/employee-table.component';
import { LoginComponent } from './login/login.component';
import { UserTableComponent } from './user-table/user-table.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'login', component : LoginComponent},
  {path :'register-user' , component : UserComponent},
  {path : 'user-details' , component : UserTableComponent},
  {path: 'service-booking/:id', component : BookingComponent},
  {path :'user-details/register-user' , component : UserComponent},
  {path :'update-user/:id' , component : UserUpdateComponent },
  {path :'booking-list/:id' , component : BookingListComponent },
  {path :'employee-details' , component : EmployeeTableComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
