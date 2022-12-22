import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterLogedInComponent } from './after-loged-in.component';

describe('AfterLogedInComponent', () => {
  let component: AfterLogedInComponent;
  let fixture: ComponentFixture<AfterLogedInComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfterLogedInComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AfterLogedInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
