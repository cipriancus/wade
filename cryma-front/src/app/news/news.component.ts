import {Component, OnInit} from '@angular/core';
import {News} from "../model/News";
import {NewsService} from "../service/news-service/news.service";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  newsList: News[];

  constructor(
    private newsService: NewsService
  ) { }

  ngOnInit() {
    this.getAllNews();
  }

  getAllNews(): void {
    this.newsService.getAllNews().subscribe(
      news => this.newsList = news
    );
  }

}
