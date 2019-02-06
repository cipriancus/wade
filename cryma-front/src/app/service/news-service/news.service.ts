import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {News} from "../../model/News";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  url = 'http://localhost:8094/news';

  constructor(private http: HttpClient) { }

  getAllNews(): Observable<News[]>{
    return this.http.get<any>(this.url).pipe(
      map(
        (request:any) =>{
          return request._embedded.news
          }
      )
    );
  }
}
