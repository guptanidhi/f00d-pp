import { Component, OnInit, Input } from '@angular/core';

import { Location }                 from '@angular/common';
import { UsersService } from './../../services/users.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-favourite-restaurants',
  templateUrl: './favourite-restaurants.component.html',
  styleUrls: ['./favourite-restaurants.component.css'],
  providers: [UsersService]
})
export class FavouriteRestaurantsComponent implements OnInit {
  @Input() fetchedRestaurants:any;
  noRestaurantsFound = false;
  str: string;
  userId = localStorage.getItem('userId');
  constructor(private usersApi:UsersService,
    private location: Location) { }

  ngOnInit() {
    this.usersApi.getUsersRestaurants().then((res)=>{
      if(res){
        this.fetchedRestaurants = res;
      }
      if(this.fetchedRestaurants.length == 0){
        this.noRestaurantsFound = true;
      }
    },(err)=>{
      this.noRestaurantsFound = true;
    })
  }

  deleteRestaurant(id): void {
    this.usersApi.deleteUsersRestaurant(id).then(()=>{
      this.fetchedRestaurants=this.fetchedRestaurants.filter((obj)=>{
        return obj.id!==id;
      })
    });
  }
        
sendValues(id_put,restaurant,comments): void {
  //do sth with the str e.g. console.log(this.str);
    this.usersApi.updateUsersRestaurant(id_put,comments,restaurant).then(()=>
      this.goBack()
  //     this.fetchedRestaurants=this.fetchedRestaurants.filter((obj)=>{
  //       console.log(obj.comments)
  // console.log("string"+this.str);
  //       return obj.comments!==this.str;
  //     })
  //     console.log(this.fetchedRestaurants);
    );

  }
  goBack(): void {
    window.location.reload();
  }
}