import { ChangeDetectorRef, Component,OnInit } from '@angular/core';
import { SpinnerService } from '../services/spinner-service';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent  implements OnInit {
  showSpinner = false;
  constructor(private spinnerService:SpinnerService, private cdRef: ChangeDetectorRef){
    
  }
  ngOnInit(): void {
    this.init();
  }
  init(){
    this.spinnerService.getSpinnerObserver().subscribe((status)=>{
      this.showSpinner = status=== 'start';
      this.cdRef.detectChanges();
    })
  }
  
}
