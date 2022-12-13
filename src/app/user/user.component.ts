import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { AddressComponent } from '../address/address.component';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent {
  admin : any;
  
  constructor(private userData : PostMethodService){
    this.userData.getUrl().subscribe((data)=>{
      console.log(data);
      this.admin=data;
    })
  }
  getData(data: any){
    console.log(data)
    // this.userData.saveData(data).subscribe((result:any)=>{
    //   console.log(result); 
    // })
  }
}
