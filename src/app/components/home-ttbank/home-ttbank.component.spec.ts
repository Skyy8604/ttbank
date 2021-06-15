import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeTtbankComponent } from './home-ttbank.component';

describe('HomeTtbankComponent', () => {
  let component: HomeTtbankComponent;
  let fixture: ComponentFixture<HomeTtbankComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeTtbankComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeTtbankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
