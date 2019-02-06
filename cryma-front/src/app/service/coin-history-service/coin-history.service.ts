import { Injectable } from '@angular/core';
import {CoinHistory} from "../../model/CoinHistory";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CoinHistoryService {

  private coinURL= 'http://localhost:8080/coin/';

  constructor(private http: HttpClient) { }

  getCoinHistoryForId(id: number): Observable<CoinHistory[]>{
    return this.http.get<CoinHistory[]>(this.coinURL + id +'/coinHistory').pipe(
      map( (response: any) =>{
        return response._embedded.history;
      }
      )
    );
  }
}
