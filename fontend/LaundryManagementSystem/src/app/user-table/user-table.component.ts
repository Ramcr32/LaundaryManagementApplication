import { Component } from '@angular/core';
import { PostMethodService } from '../services/post-method.service';
import { Router } from '@angular/router';
import { DataTransferService } from '../services/data-transfer.service';
import { Query } from '../services/query';
@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent {
  users : any;
  query:Query=new Query();
  flag:boolean=false;
  count:any;
  constructor(private userData : PostMethodService, private router: Router, private dtxr: DataTransferService){
    this.dtxr.updateApprovalMessage(true);
    
    this.sSCustomers()

  }
  sSCustomers(){
    
    // console.log(this.query)
    this.userData.getSearchCustomer(this.query).subscribe((data:any)=>{
      this.users=data.content;
      this.count= data.count;
      console.log(this.count)
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
