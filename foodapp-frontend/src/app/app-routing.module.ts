import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { SearchRestaurantsComponent } from './components/search-restaurants/search-restaurants.component';
import { DisplayRestaurantsComponent } from "./components/search-restaurants/display-restaurants/display-restaurants.component";
import { FavouriteRestaurantsComponent } from './components/favourite-restaurants/favourite-restaurants.component';

const routes: Routes = [
  
  {
    path:'',
    component: SearchRestaurantsComponent
  },
  {
    path:'home',
    component: SearchRestaurantsComponent
  },
  {
    path:'restaurants',
    component: DisplayRestaurantsComponent
  },
  {
    path: 'favourites',
    component: FavouriteRestaurantsComponent
  }
];

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule {}
