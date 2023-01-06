import { Component } from '@angular/core';

import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { DataTransferService } from '../services/data-transfer.service';
import { Query } from '../services/query';
@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent {
  users : any;
  query:Query=new Query();
  flag:boolean=false;
  count:any;
  bNext :boolean= true;
  noOfPage:number=0;
  numSequence(n: number): Array<number> {
        return Array(n);
  }
  constructor(private userData : PostMethodService, private router: Router, private dtxr: DataTransferService){
    this.dtxr.updateApprovalMessage(true);
    
    this.sSCustomers()
    
  }
  sSCustomers(){
    
    // console.log(this.query)
    this.userData.getEmployeeData().subscribe((data:any)=>{
      this.users=data
      // this.count= data.count;
      // this.noOfPage= Math.ceil( this.count/this.query.pageSize);
      // console.log(this.noOfPage)
      
    })
  }
  
  sSearch(text:any){
    this.query.searchQuery=text;
    this.sSCustomers();
  }
  pageSize(text:any){
    this.query.pageSize= parseInt(text) ;
    if(!isNaN(this.query.pageSize)){
      this.sSCustomers();
    }
    
  }
  sSorting(text:any){
    this.query.sorting=text;
    this.sSCustomers();
  }
  sTitle(text:any){
    this.query.title=text;
    this.sSCustomers();
  }
  sPage(event:any){
      console.log(event)
      if(event == "Next"){
       
          var c = this.count/this.query.pageSize
          
        if(this.query.pageNumber<c){
          this.query.pageNumber=this.query.pageNumber+1
          this.sSCustomers();
        }else{
            this.bNext=false;
        }
        
        
      }
      else if(event == "Previous"){
        if(this.query.pageNumber>1){
          this.query.pageNumber=this.query.pageNumber-1
          this.sSCustomers();
        }
        
      }
      else {
        
        this.query.pageNumber= Number(event);
        this.sSCustomers();
      }
      
    
  }
  deleteService(id:any){
    console.log(id)
    this.userData.deleteCustomer(id).subscribe((data:any)=>{
        console.warn(data);
    });
  }
  updateService(id:any){
    this.router.navigate(['update-user',id]);
  }
  viewService(id:any){
    this.router.navigate(['booking-list',id]);
  }
}
