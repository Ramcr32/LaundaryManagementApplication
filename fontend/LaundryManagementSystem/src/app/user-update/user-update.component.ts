import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent {
  user:any;
  address:any;
  id:any;
  ngOnInit():void{




    this.id=this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id).subscribe(data=>{

      this.employee=data;

      this.addresses=data.addresses;

      this.designation=data.designation;

      console.log(this.addresses);



      //console.log(data);

    })



  }






  constructor(private employeeService:EmployeeService,private router:Router,private route:ActivatedRoute){



  }



  onSubmit(){

    //console.log(this.employee);

    console.log(this.employee);

    this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>{

      console.log(data);

      this.goToEmployeeList();

    },error=>

    alert(error.error.message) )



  };
}
