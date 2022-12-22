import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { BookingComponent } from './booking/booking.component';
import { LoginComponent } from './login/login.component';
import { AfterLogedInComponent } from './after-loged-in/after-loged-in.component';
const routes: Routes = [
  {path:'register-form',component: UserComponent},
  {path:'service-booking', component: BookingComponent },
  
  {path:'home', component: LoginComponent},
  {path:'after-login',component:AfterLogedInComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
