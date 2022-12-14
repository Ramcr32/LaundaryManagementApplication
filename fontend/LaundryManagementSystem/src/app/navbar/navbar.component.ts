
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DataTransferService } from '../services/data-transfer.service';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  flage: boolean = false;
  key: String = "";
  constructor(private dtxr: DataTransferService, private post: PostMethodService, private route: Router) {
    this.dtxr.currentApprovalStageMessage.subscribe((result: boolean) => {
      this.flage = result;
    })
  }
  logOut() {
    // this.key = localStorage.getItem("key") + "";
    // this.key = this.key.slice(1, 7);
    // console.log(this.key)
    // this.post.logoutAdminData(this.key).subscribe((result: any) => {

    //   console.log(result)
    //   this.dtxr.updateApprovalMessage(false);
    // });
    localStorage.removeItem("key")
    setTimeout(function () {
      window.location.href = "http://localhost:4200/";
    }, 1000);

  }


}


