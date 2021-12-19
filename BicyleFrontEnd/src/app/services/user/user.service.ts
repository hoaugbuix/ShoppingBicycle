import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly URL = environment.apiBaseUrl + '/api/v1/user';
  // private header = new Headers({ 'Content-Type': 'application/json' });
  // options: any = { headers: this.header, withCredentials: true };

  constructor(private http: HttpClient) { }

  login<T>(parameter: any): Observable<T> {
    const body: any = parameter;
    return this.http.post<T>(this.URL + `/login`, body);
  }

}
