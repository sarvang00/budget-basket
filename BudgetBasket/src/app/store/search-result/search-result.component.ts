import { Component } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent {
  searchKeyword!: String;
  public searchResults!: any;
  constructor(private searchService: SearchService) {
    this.searchKeyword = this.searchService.searchKeyword;
    this.searchService.getSearchProducts().subscribe((searchResults) => this.searchResults=searchResults);
    // console.log("Mit gayi dooriyan ", this.searchResults)
  }
}
