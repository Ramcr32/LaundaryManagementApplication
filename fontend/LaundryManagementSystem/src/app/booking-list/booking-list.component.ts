import { Component } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { DataTransferService } from '../services/data-transfer.service';
@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent {
  serviceData:any;
  serviceId:any;
  customerId:any;
  constructor(private booking: BookingServiceService,private router:Router,private route:ActivatedRoute,private dtxr: DataTransferService){
    dtxr.updateApprovalMessage(true);
    this.customerId=this.route.snapshot.params['id'];
        this.booking.getServiceDataByCustomerId(this.customerId).subscribe((result:any)=>{
          console.log(result)
            this.serviceData=result;
            
           
        })
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
        this.booking.deleteService(this.serviceId).subscribe((result:any)=>{
          // console.log(result);
        })
        window.location.reload();
      }
}
