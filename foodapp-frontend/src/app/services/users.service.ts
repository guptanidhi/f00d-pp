import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UsersService{
  idd:any;
  url_put='http://localhost:8080/restaurantService/updateRestaurant/';
  url='http://localhost:8080/restaurantService/deleteRestaurant/';
  private headers = new Headers({'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*', 'Authorization': 'Bearer '+localStorage.getItem('token')});
  constructor(private http: Http){}

  getUsersRestaurants(): Promise<void> {
    return this.http.get('http://localhost:8080/restaurantService/getMyRestaurants', {headers: this.headers})
      .toPromise()
      .then((res)=>res.json(),
      (err)=>err.json())
  }

  //converted promise type to void from string
  addUsersRestaurants(res): Promise<void> {
    return this.http.post('http://localhost:8080/restaurantService/addRestaurant',JSON.stringify({
      id: res.restaurant.id,
      name: res.restaurant.name,
      featuredImage:res.restaurant.featured_image,
      cuisines:res.restaurant.cuisines,
      averageCostForTwo:res.restaurant.average_cost_for_two,
      rating:res.restaurant.user_rating.aggregate_rating,
      comments:null,
      userId: localStorage.getItem('userId')
    }),{headers: this.headers})
        .toPromise()
        .then(
        (err)=>console.log(err))
        .catch((ress) =>alert(ress._body))
  }

  deleteUsersRestaurant(id): Promise<void> {
    // return this.http.delete(`/Favourites/${id}`)
    return this.http.delete(this.url+id, {headers: this.headers})
      .toPromise()
      .then(
        (err)=>console.log(err))
  }

  updateUsersRestaurant(idd,res,comments): Promise<void> {
  // return this.http.delete(`/Favourites/${id}`)
    console.log("Commnets", comments);
    return this.http.put(this.url_put+idd+"?comments="+comments,JSON.stringify({
      id: res.id,
      name: res.name,
      featured_image:res.featured_image,
      cuisines:res.cuisines,
      average_cost_for_two:res.average_cost_for_two,
      rating:res.aggregate_rating,
      comments:comments
    }),{headers: this.headers})
      .toPromise()
      .then(()=>res,
        (err)=>console.log(err))
  }
}    