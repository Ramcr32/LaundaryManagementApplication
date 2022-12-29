import { DataTransferService } from '../services/data-transfer.service';
import { Component } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Booking } from '../services/booking';
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  book:Booking= new Booking();
  serviceData: any;
  errMessage:any;

 
  constructor(private booking: BookingServiceService,private router:Router, private route: ActivatedRoute,private dtxr: DataTransferService){
        this.book.customerId=this.route.snapshot.params['id'];
        dtxr.updateApprovalMessage(true)
    
    
//     this.booking.getAllServiceData().subscribe((result:any)=>{
//       console.log(result)
//         this.serviceData=result;
//         ;
//        
//     }
//     ,err => {
//       this.serviceData=err.error;
//       console.log(err.error);
//     }
//     )
  };
  getBooking(data:any){
    this.book.bookingDate=data.bookingDate;
    this.book.empId=data.empId;
    this.book.piece=data.piece;
    this.book.price=data.piece*10;
    
    
    this.booking.saveServiceData(this.book).subscribe((result : any)=>{
//       console.log(result);
        this.router.navigate(['booking-list',this.book.customerId]);
    }
    ,err=>{
      this.errMessage=err.error.message;
      alert(this.errMessage);
    }
    );
   
   
  }
 
}


