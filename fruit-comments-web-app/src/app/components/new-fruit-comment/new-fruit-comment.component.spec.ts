import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewFruitCommentComponent } from './new-fruit-comment.component';

describe('NewFruitCommentComponent', () => {
  let component: NewFruitCommentComponent;
  let fixture: ComponentFixture<NewFruitCommentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewFruitCommentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewFruitCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
