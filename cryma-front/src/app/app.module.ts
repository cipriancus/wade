import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewsComponent } from './news/news.component';
import { PlotComponent } from './plot/plot.component';
import { ConvertComponent } from './convert/convert.component';
import { CoinHistoryComponent } from './coin-history/coin-history.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    PlotComponent,
    ConvertComponent,
    CoinHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
