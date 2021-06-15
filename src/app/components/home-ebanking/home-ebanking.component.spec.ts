import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeEbankingComponent } from './home-ebanking.component';

describe('HomeEbankingComponent', () => {
  let component: HomeEbankingComponent;
  let fixture: ComponentFixture<HomeEbankingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeEbankingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeEbankingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
