import { Injectable,Injector } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptorInterceptor implements HttpInterceptor {

  constructor(private injector:Injector) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token :string | null = localStorage.getItem("key")  ; // you probably want to store it in localStorage or something
    // let authService = this.injector.get(PostMethodService)
    // console.warn(token)
    if (!token) {
      return next.handle(request);
    }

    request = request
    .clone({
      // headers: request.headers
      //       // .set('Content-type', 'application/vnd.flux')
      //       .set('Authorization',token)
      //        .set('Access-Control-Allow-Origin', '*')
      //       .set('Access-Control-Allow-Methods',['POST','GET'] )
            
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': token
        
      })
    });
        
    return next.handle(request);
  }
}
