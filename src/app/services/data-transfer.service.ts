import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class DataTransferService {
  flage:boolean= false;
  
  constructor() { }
  // private data = new BehaviorSubject(this.flage);
  private approvalStageMessage = new BehaviorSubject(this.flage);
 currentApprovalStageMessage = this.approvalStageMessage.asObservable();

 updateApprovalMessage(bool:boolean) {
    this.approvalStageMessage.next(bool)
  }
}
