import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowparentComponent } from './showparent.component';

describe('ShowparentComponent', () => {
  let component: ShowparentComponent;
  let fixture: ComponentFixture<ShowparentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowparentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowparentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
