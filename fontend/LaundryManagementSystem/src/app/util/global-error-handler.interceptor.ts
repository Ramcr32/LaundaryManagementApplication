import { ErrorHandler, Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable()
export class GlobalErrorHandlerInterceptor implements ErrorHandler{

  constructor() {}
  handleError(error: any): void {
    throw new Error('global error handler');
  }

  
}
