import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { LoginComponent } from './login/login.component';
import { UserTableComponent } from './user-table/user-table.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'login', component : LoginComponent},
  {path :'register-user' , component : UserComponent},
  {path : 'user-details' , component : UserTableComponent},
  {path: 'service-booking', component : BookingComponent},
  {path :'user-details/register-user' , component : UserComponent},
  {path :'update-user/:id' , component : UserUpdateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
