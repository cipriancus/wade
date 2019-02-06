import { Component, OnInit } from '@angular/core';
import {CoinHistory} from "../model/CoinHistory";
import {Coin} from "../model/Coin";
import {ActivatedRoute} from "@angular/router";
import {CoinHistoryService} from "../service/coin-history-service/coin-history.service";
import {PlotService} from "../service/plot-service/plot.service";

@Component({
  selector: 'app-coin-history',
  templateUrl: './coin-history.component.html',
  styleUrls: ['./coin-history.component.css']
})
export class CoinHistoryComponent implements OnInit {

  selectedCoin: Coin;
  coinHistory: CoinHistory[];

  constructor(private route: ActivatedRoute,
              private coinHistoryService: CoinHistoryService,
              private plotService: PlotService) { 
                this.selectedCoin = new Coin();
              }

  ngOnInit() {
    this.getSelectedCoin();
  }

  getSelectedCoin(): void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.plotService.getCoinForId(id)
      .subscribe(coin => {
        this.selectedCoin = coin
        this.getCoinHistory();
      });
  }

  getCoinHistory(): void{
     this.coinHistoryService.getCoinHistoryForId(this.selectedCoin.id)
       .subscribe( coins => {
         this.coinHistory = coins
        });
  }
}
