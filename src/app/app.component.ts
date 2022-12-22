import { Component } from '@angular/core';
import{NgForm} from '@angular/forms'
import { PostMethodService } from './services/post-method.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'laundryManagementApplication';
  // flag=false;
  // email:any;
  // password:any;
  // errMessage: any="";
  // constructor(private post : PostMethodService,private route : Router){};

  // loginCheck(data:any){
    
  //   // console.log(data)
  //     this.post.loginAdminData(data).subscribe((result)=>{
  //       console.log(result);
        
  //     },err=>{
        
  //       this.errMessage= err.error.message;
       
  //     }
  //     )
  //     if(this.errMessage==""){
  //         this.flag=true;
  //     }
  //     // this.route.navigate(['after-login']);
  //     // window.location.href='http://localhost:4200/';
  // }
  
  

}

