import { TestBed } from '@angular/core/testing';

import { CoinHistoryService } from './coin-history.service';

describe('CoinHistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoinHistoryService = TestBed.get(CoinHistoryService);
    expect(service).toBeTruthy();
  });
});
