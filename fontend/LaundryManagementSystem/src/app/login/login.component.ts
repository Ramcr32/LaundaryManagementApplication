
import { Component ,EventEmitter,OnInit,Output} from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { DataTransferService } from '../services/data-transfer.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email:any;
  password: any;
  errMessage: string="";
  flag:boolean=false;
  msg :string="";
  // errors : boolean=false;
 
  constructor(private post : PostMethodService,private route : Router , private datatxr: DataTransferService){};
 
  loginCheck(data:any){
   
      console.log(data)
      this.post.loginAdminData(data).subscribe((result:any)=>{
        // console.log(result.message);
        this.msg=result.message;
        localStorage.setItem("key",JSON.stringify(result.message));
       
      },err=>{
          // this.errMessage= err.error.message;
          console.log(this.errMessage)
      })
      if(this.msg!=""){
        this.datatxr.updateApprovalMessage(true);
      }
     
      // let d =  localStorage.getItem("key")
     
      // this.datatxr.currentApprovalStageMessage.subscribe((errMessage)=>{
      //       this.errMessage=errMessage
      // })

     
     
     
     
     
  }

  // this.route.navigate(['after-login']);
      // window.location.href='http://localhost:4200/';

}


