
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { DataTransferService } from '../services/data-transfer.service';
import { ActivatedRoute } from '@angular/router';
import { SpinnerService } from '../services/spinner-service';
@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    email: any;
    password: any;
    errMessage: string = "";
    flag: boolean = false;
    msg: string = "";
    // errors : boolean=false;

    constructor(private post: PostMethodService, private router: Router, private datatxr: DataTransferService,
        private route: ActivatedRoute , private spinnerService: SpinnerService) { };

    loginCheck(data: any) {

        // console.log(data)
        this.spinnerService.requestStarter();
        this.post.loginAdminData(data).subscribe((result: any) => {
            // console.log(result.message);
            this.spinnerService.requestEnded();
            this.msg = result.message;
            localStorage.setItem("key", JSON.stringify(result.message));

        }, err => {
            this.spinnerService.requestEnded();
            this.errMessage = err.error.message;
            // console.log(this.errMessage)
        })
        if (this.msg != "") {
            this.datatxr.updateApprovalMessage(true);
            this.router.navigate(['user-details']);
        }

        // let d =  localStorage.getItem("key")

        // this.datatxr.currentApprovalStageMessage.subscribe((errMessage)=>{
        //       this.errMessage=errMessage
        // })






    }

    // this.route.navigate(['after-login']);
    // window.location.href='http://localhost:4200/';

}


