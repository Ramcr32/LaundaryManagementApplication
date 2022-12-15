import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { AddressComponent } from '../address/address.component';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent {
  jsonData : any;
  user : any;
  userName: any = 'name';
     mobile: any = 'number';
      
      password : any ="pass";
      email : any = "email";
  address : AddressComponent = new AddressComponent();
  

  constructor(private userData : PostMethodService){
    this.userData.getUrl().subscribe((data)=>{
      // console.log(data);
      this.jsonData=data;
    })
  }
  getUser(userType: string){
    // console.log(userType)
    this.user = userType;
  }
  getData(data: any){
    // console.warn(data)
    var object :Object = {
        userName : data.userName,
        mobile : data.mobile,
        password : data.password,
        email : data.email,
        address : {
          pincode : data.pincode,
          city : data.city,
          state : data.state,
          country : data.country
        }
    }
    // console.log(object)

    if(this.user=="admin"){
      this.userData.saveAdminData(object).subscribe((result:any)=>{
      console.log(result); 
      })
    }
    else if(this.user=="customer"){
      this.userData.saveCustomerData(object).subscribe((result:any)=>{
        console.log(result); 
        })
    }
    else if(this.user=="employee"){
      this.userData.saveEmployeeData(object).subscribe((result:any)=>{
        console.log(result); 
        })
    }
  }
}
