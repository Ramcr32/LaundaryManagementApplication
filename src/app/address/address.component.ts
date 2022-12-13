import { Component , OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
    city = "";
    state = "";
    pincode = "";
    country = "";
    @Output() addressEvent = new EventEmitter();
    ngOnInit(){

    }
    addressEventMethos(){
        this.addressEvent.emit();
    }

}
