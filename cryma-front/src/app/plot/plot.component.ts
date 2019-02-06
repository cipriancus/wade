import { Component, OnInit } from '@angular/core';
import { PlotService } from '../service/plot-service/plot.service';
import { Coin } from '../model/Coin';

@Component({
  selector: 'app-plot',
  templateUrl: './plot.component.html',
  styleUrls: ['./plot.component.css']
})
export class PlotComponent implements OnInit {

  coins: Coin[];

  constructor(private plotService: PlotService) { }

  ngOnInit() {
    this.getAllCoinsValues();
  }

  getAllCoinsValues(): void {
    this.plotService.getAllCoinsValues().subscribe(
        coins=>this.coins=coins  
    );
  }
}
