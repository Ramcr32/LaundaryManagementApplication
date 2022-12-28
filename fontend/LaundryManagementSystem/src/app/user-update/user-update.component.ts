import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { User } from '../util/user';
import { Address } from '../util/address';
@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent {
  user:User= new User();

  id:any;
  ngOnInit():void{

    this.id=this.route.snapshot.params['id'];

    this.post.getCustomerById(this.id) .subscribe((data:any)=>{

      this.user=data;
      // console.log(this.user)
    })



  }


  constructor(private post:PostMethodService,private router:Router,private route:ActivatedRoute){  }



  onUpdate(data:any){
      this.user.userName=data.userName;
      this.user.mobile=data.mobile;
      this.user.email=data.email;
      this.user.address.city=data.city;
      this.user.address.country=data.country;
      this.user.address.state=data.state;
      this.user.address.pincode=data.pincode
      // console.log(this.user)
      this.post.updateCustomer(this.user).subscribe((result:any)=>{

      })
      this.router.navigate(['user-details'])
  };
}
