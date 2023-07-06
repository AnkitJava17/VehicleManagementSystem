import { TestBed } from '@angular/core/testing';

import { TripSharedDataService } from './trip-shared-data.service';

describe('TripSharedDataService', () => {
  let service: TripSharedDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TripSharedDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
