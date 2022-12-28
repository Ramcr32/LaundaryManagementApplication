
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class PostMethodService {
  url="http://localhost:8888/admin/"
  constructor(private http:HttpClient) { }

  getUrl(){

    return this.http.get(this.url);

  };
  url1="http://localhost:8888/admin/"
  saveAdminData(data : any){
    return this.http.post(this.url1,data);
  }
  url2="http://localhost:8888/customer/"
  saveCustomerData(data: any){
    return this.http.post(this.url2,data);
  }
  url3="http://localhost:8888/Employee/"
  saveEmployeeData(data: any){
    return this.http.post(this.url3,data);
  }

  //login
  url4="http://localhost:8888/admin/login"
  loginAdminData(data : any){
    return this.http.post(this.url4,data);
  }
  //logout
  url5="http://localhost:8888/admin/logout"
  logoutAdminData(key : any){
    return this.http.patch(this.url5+"?key="+`${key}`,key);
  }

  url6="http://localhost:8888/customer/"
  getCustomer(){
    return this.http.get(this.url6);
  }
  deleteCustomer(id:any){
    return this.http.delete(this.url6+`${id}`)
  }
  getCustomerById(id:any){
    return this.http.get(this.url6+`${id}`);
  }
  updateCustomer(data : any){
        return this.http.put(this.url6,data);
  }
}


