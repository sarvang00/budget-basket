import { TestBed } from '@angular/core/testing';

import { FinManagerService } from './fin-manager.service';

describe('FinManagerService', () => {
  let service: FinManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FinManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
