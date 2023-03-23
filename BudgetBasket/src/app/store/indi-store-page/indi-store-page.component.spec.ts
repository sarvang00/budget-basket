import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndiStorePageComponent } from './indi-store-page.component';

describe('IndiStorePageComponent', () => {
  let component: IndiStorePageComponent;
  let fixture: ComponentFixture<IndiStorePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IndiStorePageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IndiStorePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
