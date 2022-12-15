import { Component } from '@angular/core';
import { UserComponent } from '../user/user.component';
import { PostMethodService } from '../services/post-method.service';
@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent {
  users : any;
  constructor(private userData : PostMethodService){
    this.userData.getUrl().subscribe((data)=>{
      
      this.users=data;
      console.log(this.users);
    })
  }
}
