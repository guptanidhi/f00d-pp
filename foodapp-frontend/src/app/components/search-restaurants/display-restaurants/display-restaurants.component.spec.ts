import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayRestaurantsComponent } from './display-restaurants.component';
import { ZomatoService } from '../../../services/zomato.service';
import { UsersService } from '../../../services/users.service';
import { HttpModule } from '@angular/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('DisplayRestaurantsComponent', () => {
  let component: DisplayRestaurantsComponent;
  let fixture: ComponentFixture<DisplayRestaurantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayRestaurantsComponent ],
      providers: [UsersService,ZomatoService],
      imports:[HttpModule,RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
