import { Component } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent {
  serviceData:any;
  serviceId:any;
  constructor(private booking: BookingServiceService){
    
        this.booking.getAllServiceData().subscribe((result:any)=>{
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
