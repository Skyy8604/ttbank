import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeTTBankComponent } from './home-ttbank.component';

describe('HomeTtbankComponent', () => {
  let component: HomeTTBankComponent;
  let fixture: ComponentFixture<HomeTTBankComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeTTBankComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeTTBankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
