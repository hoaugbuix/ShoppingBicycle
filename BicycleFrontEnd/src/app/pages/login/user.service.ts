import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  api: any = environment.apiBaseUrl + '/api/v1/user';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options: any = { headers: this.headers, withCredentials: true };

  constructor(private http: HttpClient) { }


  login(parameters: any): Observable<any> {
    const body: any = parameters;
    return this.http.post(`${this.api}/login`, body, this.options);
  }
}
