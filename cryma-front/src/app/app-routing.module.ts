import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlotComponent } from './plot/plot.component';
import { NewsComponent } from './news/news.component';
import { ConvertComponent } from './convert/convert.component';
import {CoinHistoryComponent} from "./coin-history/coin-history.component";

const routes: Routes = [
  { path: '', redirectTo: '/plot', pathMatch: 'full' },
  { path: 'plot', component: PlotComponent },
  { path: 'convert', component: ConvertComponent },
  { path: 'news', component: NewsComponent },
  { path: 'history/:id', component: CoinHistoryComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
