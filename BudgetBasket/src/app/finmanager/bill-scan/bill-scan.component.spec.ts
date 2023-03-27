import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillScanComponent } from './bill-scan.component';

describe('BillScanComponent', () => {
  let component: BillScanComponent;
  let fixture: ComponentFixture<BillScanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillScanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillScanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
