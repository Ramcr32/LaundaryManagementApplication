import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email:any;
  password: any;
  errMessage: any;
  errors : boolean=false;
  constructor(private post : PostMethodService){};

  loginCheck(data:any){
      console.log(data)
      this.post.loginAdminData(data).subscribe(()=>{

      },err=>{
        this.errors =true;
        this.errMessage= err.error.message;
        
      }
      )

  }
}
