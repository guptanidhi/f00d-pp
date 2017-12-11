import { Component, OnInit } from '@angular/core';
import { ZomatoService } from './../../services/zomato.service';
import { trigger, style, state, transition, animate } from '@angular/animations';
import * as $ from 'jquery';

import { AgmCoreModule } from '@agm/core';

@Component({
  selector: 'app-search',
  templateUrl: './search-restaurants.component.html',
  styleUrls: ['./search-restaurants.component.css'],
  providers: [ZomatoService]
  /*animations: [
    trigger('slideInOut', [
      state('in', style({
        transform: 'translate3d(0, 0, 0)'
      })),
      state('out', style({
        transform: 'translate3d(100%, 0, 0)'
      })),
      transition('in => out', animate('400ms ease-in-out')),
      transition('out => in', animate('400ms ease-in-out'))
    ]),
  ]*/
})
export class SearchRestaurantsComponent implements OnInit{
  lat: number;
  lng: number;
  mapOptions = {
    lat: null,
    lng: null,
    zoom: 15
  }
  toggleClass: string = 'left';
  restaurants:any;
  markers: any = [];
  // menuState:string = 'out';

  constructor(private zomato: ZomatoService){
    
  }

  ngOnInit(){
    let self = this;
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(result){
        self.mapOptions.lat = result.coords.latitude;
        self.mapOptions.lng = result.coords.longitude;
      });
    } else {
        //browser does not support geolocation
    }
  }

  fetchRestaurants(cityName, cuisineName) {
    this.restaurants=[];
    this.zomato.getRestaurants(cityName, cuisineName).then(
      (data)=> {
        this.restaurants = data;
        let markers = [];
        for(let i=0;i<this.restaurants.length;i++){
          let markerObj = {
            name: null,
            lat: null,
            lng: null,
            rating: null,
            votes: null,
            thumb: null
          };
          markerObj.name = this.restaurants[i].restaurant.name;
          markerObj.lat = parseFloat(this.restaurants[i].restaurant.location.latitude);
          markerObj.lng = parseFloat(this.restaurants[i].restaurant.location.longitude);
          markerObj.rating = this.restaurants[i].restaurant.user_rating.aggregate_rating;
          markerObj.votes = this.restaurants[i].restaurant.user_rating.votes;
          markerObj.thumb = this.restaurants[i].restaurant.thumb;
          markers.push(markerObj);
        }
        this.mapOptions.zoom = 12;
        this.markers = markers;
    });
  }
  
  
  toggleMenu() {
    // 1-line if statement that toggles the value:
    // this.menuState = this.menuState === 'out' ? 'in' : 'out';
    this.toggleClass = this.toggleClass == 'right' ? 'left':'right';
    $('#criteria-subpanel').toggle("slow");
    if(this.toggleClass == 'right'){
      $(".agmMap").css("padding-left", "0");
    } else{
      $(".agmMap").css("padding-left", "30%");
    }
  }

  onMouseOver(infoWindow) {
    infoWindow.open();
  }

  onMouseOut(infoWindow){
    infoWindow.close();
  }

}