import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Store } from '../store/models/Store'

@Injectable({
  providedIn: 'root'
})
export class IstoreService {
  public storeName!: String;
  public storeSubject: BehaviorSubject<any> = new BehaviorSubject(null);
  public publicIP: String = "34.152.13.63";

  constructor(private httpClient : HttpClient) { }

  getKrogerProducts(): Observable<any> {
    return this.httpClient.get('http://'+this.publicIP+':9090/product/getAllProductsFromKroger').pipe(tap((storeData: any) => {
      // console.log("Main yahan: ", storeData);
      this.storeSubject.next(storeData);
    }));
  }

  getAideProducts(): Observable<any> {
    return this.httpClient.get('http://'+this.publicIP+':9090/product/getAllProductsFromAide').pipe(tap((storeData: any) => {
      // console.log("Main yahan: ", storeData);
      this.storeSubject.next(storeData);
    }));
  }

  getTraderJoeProducts(): Observable<any> {
    return this.httpClient.get('http://'+this.publicIP+':9090/product/getAllProductsFromTraderJoe').pipe(tap((storeData: any) => {
      // console.log("Main yahan: ", storeData);
      this.storeSubject.next(storeData);
    }));
  }
}
