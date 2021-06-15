import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHisctoricTradesComponent } from './list-hisctoric-trades.component';

describe('ListHisctoricTradesComponent', () => {
  let component: ListHisctoricTradesComponent;
  let fixture: ComponentFixture<ListHisctoricTradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListHisctoricTradesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListHisctoricTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
