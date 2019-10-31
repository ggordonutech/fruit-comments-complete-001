import { Injectable } from '@angular/core';
import { Fruit } from './../entities/fruit';
import { Observable, of } from 'rxjs';
import { ajax } from 'rxjs/ajax';
import {map, catchError} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class FruitService {
  private items: Fruit[]=[];

  constructor() { }

  public getAll() : Observable<Fruit[]> {
    let fruitsApi = ajax('http://localhost:9003/api/fruits.json')
       .pipe(
         map(res=> {
           if(!res.response){
             throw new Error("NO FRUIT DATA RECEIVED");
           }
           return res.response as Fruit[];
         }),
         catchError(err =>{
           console.error(err);
           return of([] as Fruit[])
         })
       )
    return fruitsApi;
  }


}
