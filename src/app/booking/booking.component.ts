import { Component } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  serviceId:number=0;
  customerId:any;
  empId:any;
  bookingDate:any;
  piece:number=0;
  price:number=this.piece*10;
  serviceData: any;
  errMessage:any;

  //login
  email:any;
  password:any;
  constructor(private booking: BookingServiceService){
    this.booking.getAllServiceData().subscribe((result)=>{
      console.log(result)
        this.serviceData=result;
        ;
        
    },err => {
      this.serviceData=err.error;
      console.log(err.error);
    }
    )
  };
  getBooking(data:any){
    console.log(data);
    data.price=data.piece*10;
    this.booking.saveServiceData(data).subscribe((result : any)=>{
      console.log(result);
    },err=>{
      this.errMessage=err.error.message;
      alert(this.errMessage);
    }
    );
    
    
  }
  editService(data: any){
    console.log(data)
    data.price=data.piece*10;
    this.booking.updateService(data);
    setTimeout(function(){
      window.location.reload();
   }, 1000);
  }
  deleteService(id : number){
    this.serviceId=id;
    console.log(id);
    this.booking.deleteService(this.serviceId).subscribe((result)=>{
      // console.log(result);
    })
    window.location.reload();
  }
}
