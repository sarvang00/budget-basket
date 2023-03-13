import { TestBed } from '@angular/core/testing';

import { IstoreService } from './istore.service';

describe('IstoreService', () => {
  let service: IstoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IstoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
