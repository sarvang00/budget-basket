import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  public publicIP: String = "34.152.13.63";
  private categoryUrl = 'http://'+this.publicIP+':9090/category/getAllCategory';

  constructor(private http: HttpClient) { }

  getCategories() {
    return this.http.get<Category[]>(this.categoryUrl);
  }
}