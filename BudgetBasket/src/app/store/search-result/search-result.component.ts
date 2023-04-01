import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent {
  searchKeyword!: any;
  public searchResults!: any;
  constructor(private searchService: SearchService, private activeRoute: ActivatedRoute, private router: Router) {
    // console.log("Mit gayi dooriyan ", this.searchResults)
  }
  
  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.searchKeyword = params.get('searchKeyword');
      this.searchService.searchKeyword=this.searchKeyword;
      // Call any other method that needs to be called when the parameter changes
      this.searchService.getSearchProducts().subscribe((searchResults) => this.searchResults=searchResults);
    });
  }
}
