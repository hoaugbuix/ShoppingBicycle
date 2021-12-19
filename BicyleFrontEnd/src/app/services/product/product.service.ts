import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private readonly URL = environment.apiBaseUrl + '/product';
  constructor(private http: HttpClient) { }

  getAll<T>(): Observable<T> {
    return this.http.get<T>(this.URL + '/get-all');
  }
}
