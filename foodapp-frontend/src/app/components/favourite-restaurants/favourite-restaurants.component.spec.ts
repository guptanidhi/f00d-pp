import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterTestingModule } from '@angular/router/testing';

import { FavouriteRestaurantsComponent } from './favourite-restaurants.component';
import { NavComponent } from '../nav/nav.component';


describe('FavouriteRestaurantsComponent', () => {
  let component: FavouriteRestaurantsComponent;
  let fixture: ComponentFixture<FavouriteRestaurantsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavouriteRestaurantsComponent,NavComponent ],
      imports:[HttpModule,RouterTestingModule, FormsModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavouriteRestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
