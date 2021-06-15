import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPositionsOverviewComponent } from './my-positions-overview.component';

describe('MyPositionsOverviewComponent', () => {
  let component: MyPositionsOverviewComponent;
  let fixture: ComponentFixture<MyPositionsOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPositionsOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPositionsOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
