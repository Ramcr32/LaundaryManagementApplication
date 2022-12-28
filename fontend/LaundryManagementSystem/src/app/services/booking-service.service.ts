
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  constructor(private http:HttpClient) { }
  url1="http://localhost:8888/services/"
  saveServiceData(data : any){
    return this.http.post(this.url1,data);
  }
 
  getAllServiceData(){
    return this.http.get(this.url1);
  }
 
  deleteService(id: number){
    // console.log(id);
    return this.http.delete(this.url1+`${id}`)
  }
  updateService(data : any){
    return this.http.put(this.url1,data);
  }
  getServiceDataByCustomerId(id:any){
    
  }

}


