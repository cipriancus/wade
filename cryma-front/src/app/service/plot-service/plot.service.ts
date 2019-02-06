import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coin } from 'src/app/model/Coin';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PlotService {

  private coinURL= 'http://localhost:8080/coin/';

  constructor(private http: HttpClient) { }

  getAllCoinsValues(): Observable<Coin[]>{
    return this.http.get<any>(this.coinURL).pipe(
      map((response: any) => {
          return response._embedded.coin;
        }
      )
    );
  }

  getCoinForId(id: number): Observable<Coin>{
    return this.http.get<any>(this.coinURL + id);
  }
}
