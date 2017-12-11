import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ZomatoService {
  headers = new Headers({'user-key':'fe78d4e792f8dbf9ededaf11e41f9d3c'});
  constructor(private http:Http) { }

  getRestaurants(cityName, cuisineName): Promise<void> {
    return this.http.get(`https://developers.zomato.com/api/v2.1/cities?q=${cityName}`,
                    {headers: this.headers})
                    .toPromise()
                    .then(
                      (res)=> this.getAllRestaurants(res.json().location_suggestions[0].id,cuisineName)
                    );
  }

  getAllRestaurants(cityId, cuisineName): Promise<void> {
    return this.http.get(`https://developers.zomato.com/api/v2.1/search?entity_id=${cityId}&entity_type=city&q=${cuisineName}&count=20`,
                    {headers: this.headers})
                    .toPromise()
                    .then(
                      (res)=>res.json().restaurants
                    );
  }

  getRestaurantDetail(resId): Promise<void> {
    console.log(resId);
 return this.http.get(`https://developers.zomato.com/api/v2.1/restaurant?res_id=${resId}`,
                    {headers: this.headers})
                    .toPromise()
                    .then(
                      (res)=>res.json()
                    );
  }

}
