import { Component } from '@angular/core';
import { User } from '../util/user';
import { Address } from '../util/address';
import { PostMethodService } from '../services/post-method.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  user:User= new User();
  address: Address = new Address();
  jsonData : any;
  desig: any;
 
  constructor(private userData : PostMethodService){
    this.userData.getUrl().subscribe((data)=>{
      // console.log(data);
      this.jsonData=data;
    })
  }
  getUser(userType: string){
    // console.log(userType)
    this.desig = userType;
  }
  getData(data: any){
    this.user.address = this.address;

    if(this.desig=="admin"){
      this.userData.saveAdminData(this.user).subscribe((result:any)=>{
      console.log(result);
      })
    }
    else if(this.desig=="customer"){
      this.userData.saveCustomerData(this.user).subscribe((result:any)=>{
        console.log(result);
        })
    }
    else if(this.desig=="employee"){
      this.userData.saveEmployeeData(this.user).subscribe((result:any)=>{
        console.log(result);
        })
    }
    setTimeout(function(){
        window.location.href= "http://localhost:4200/user-details";
     }, 1000);
  }


}
