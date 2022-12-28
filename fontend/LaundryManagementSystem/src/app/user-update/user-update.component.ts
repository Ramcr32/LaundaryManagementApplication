import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent {
  user:any;

  id:any;
  ngOnInit():void{

    this.id=this.route.snapshot.params['id'];

    this.post.getCustomerById(this.id) .subscribe((data:any)=>{

      this.user=data;

    })



  }


  constructor(private post:PostMethodService,private router:Router,private route:ActivatedRoute){  }



  onUpdate(data:any){

    //console.log(this.employee);

    // console.log(this.employee);

    // this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>{

    //   console.log(data);

    //   this.goToEmployeeList();

    // },error=>

    // alert(error.error.message) )



  };
}
