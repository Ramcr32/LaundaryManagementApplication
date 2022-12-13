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
  saveData(data : any){
    return this.http.post(this.url,data);
  }
}
