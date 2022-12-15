import { Component , OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

    city: any = "city";
     state: any= "state";
     pincode : any= "745465";
     country :any = "india";
  
    


    // @Output() addressEvent = new EventEmitter();
    ngOnInit(){

    }
    // addressEventMethos(){
    //     this.addressEvent.emit();
    // }

}
