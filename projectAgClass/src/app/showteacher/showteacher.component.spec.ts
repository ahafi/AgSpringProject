import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowteacherComponent } from './showteacher.component';

describe('ShowteacherComponent', () => {
  let component: ShowteacherComponent;
  let fixture: ComponentFixture<ShowteacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowteacherComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowteacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
