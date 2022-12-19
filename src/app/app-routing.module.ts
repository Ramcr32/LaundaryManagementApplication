import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { BookingComponent } from './booking/booking.component';
import { LoginComponent } from './login/login.component';
const routes: Routes = [
  {path:'register-form',component: UserComponent},
  {path:'service-booking', component: BookingComponent },
  {path:'admin-login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
