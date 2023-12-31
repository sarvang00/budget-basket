import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  public searchKeyword!: String;
  public resultSubject: BehaviorSubject<any> = new BehaviorSubject(null);
  public publicIP: String = "34.152.13.63";

  constructor(private httpClient : HttpClient) { }

  getSearchProducts(): Observable<any> {
    // console.log("B4:", this.searchKeyword);
    var searchUrl = "http://"+this.publicIP+":9090/product/getAllSearchedProducts?keyword="+this.searchKeyword;
    return this.httpClient.get(searchUrl).pipe(tap((searchResults: any) => {
      // console.log("Janam dekhlo: ", searchResults);
      this.resultSubject.next(searchResults);
    }));
  }
}
