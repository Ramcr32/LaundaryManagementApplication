import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class SpinnerService {
    private count =0;
    private spinners$ = new BehaviorSubject<string>("");
    getSpinnerObserver():Observable<string>{
        return this.spinners$.asObservable();
    }
    requestStarter(){
        if(++this.count==1){
            this.spinners$.next('start');
        }
    }
    requestEnded(){
        if(this.count===0 || --this.count===0){
            this.spinners$.next('stop');
        }
    }
    resetSpinner(){
        this.count=0;
        this.spinners$.next('stop');
    }
}
