import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHistoricCashTransactionsComponent } from './list-historic-cash-transactions.component';

describe('ListHistoricCashTransactionsComponent', () => {
  let component: ListHistoricCashTransactionsComponent;
  let fixture: ComponentFixture<ListHistoricCashTransactionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListHistoricCashTransactionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListHistoricCashTransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
