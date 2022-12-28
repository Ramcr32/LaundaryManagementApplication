import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent {
  users : any;

  constructor(private userData : PostMethodService, private router: Router){

    this.userData.getCustomer().subscribe((data:any)=>{
      this.users=data;
      console.warn(this.users)
    })

  }
  deleteService(id:any){
    console.log(id)
    this.userData.deleteCustomer(id).subscribe((data:any)=>{
        console.warn(data);
    });
  }
  updateService(id:any){
    this.router.navigate(['update-user',id]);
  }
  viewService(){

  }
}
