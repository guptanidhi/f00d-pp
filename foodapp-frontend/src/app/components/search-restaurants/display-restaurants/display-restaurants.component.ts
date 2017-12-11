import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { UsersService } from '../../../services/users.service';
import { ZomatoService } from '../../../services/zomato.service';
// import { DetailedRestaurantComponent } from '../../../detailed-restaurant/detailed-restaurant.component';


@Component({
  selector: 'app-display-restaurants',
  templateUrl: './display-restaurants.component.html',
  styleUrls: ['./display-restaurants.component.css']
})

export class DisplayRestaurantsComponent implements OnInit {
  @Input() restaurantsData:any;
  filteredRestaurantData:any;
  dbRestaurantData:any = [];
  fetchedRestaurants:any;
  noRestaurantsFound = false;
  restaurantdata:any;
  isUserLoggedIn: boolean = false;

  constructor(private usersApi:UsersService,private zomato: ZomatoService) {

  }

  ngDoCheck(){
    this.isUserLoggedIn = localStorage.getItem('token') ? true: false;
  }

  ngOnInit() { 
    /*this.usersApi.getUsersRestaurants().then((res)=>{
      let response = JSON.parse(JSON.stringify(res));
      this.dbRestaurantData = response;
    },(err)=>{
      this.dbRestaurantData = [];
    });

    this.usersApi.getUsersRestaurants().then((res)=>{
      if(res){
        this.fetchedRestaurants = res;
        console.log(res);
      }
      if(this.fetchedRestaurants.length == 0){
        this.noRestaurantsFound = true;
      }
    },(err)=>{
      this.noRestaurantsFound = true;
    })*/
  }

  ngOnChanges(changes) {
    console.log("changes detected");
    if(changes.restaurantsData.currentValue){
      // console.log("changes.value"+changes.restaurantsData.currentValue)
      if(this.dbRestaurantData.length > 0){
      this.filteredRestaurantData = [];
      // console.log("inside db.length")
      for(let i = 0; i < this.dbRestaurantData.length; i++){
        for (let j = 0; j < changes.restaurantsData.currentValue.length; j++) {
          // console.log("for")
            if(this.dbRestaurantData[i].id==changes.restaurantsData.currentValue[j].restaurant.id){
              let already_exists = changes.restaurantsData.currentValue[j];
              changes.restaurantsData.currentValue[j].buttonValue = "Added to favourites";
              this.filteredRestaurantData.push(already_exists);
              // console.log("if")
            }else{
              this.filteredRestaurantData.push(changes.restaurantsData.currentValue[j]);
              // console.log("else")
            }
        }
      }
    }else{
      this.filteredRestaurantData = changes.restaurantsData.currentValue;
    }
  }
}

  addRestaurant(restaurant,id): void {

    this.usersApi.addUsersRestaurants(restaurant).then(()=>{
        this.filteredRestaurantData.filter((obj)=>{
          if(obj.restaurant.id==restaurant.restaurant.id){
            obj.buttonValue ="Added to favourites";
          }
        });
    },(err)=>{
      })
  }

  fetchRestaurantDetail(resId:number) {
console.log(resId);
    this.zomato.getRestaurantDetail(resId).then(
      (data)=> {
          this.restaurantdata = data;
          console.log("json"+this.restaurantdata);
      });
  }
 
}
