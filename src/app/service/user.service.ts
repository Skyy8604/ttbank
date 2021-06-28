import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  private readonly baseURL = 'http://localhost:8080/bbc-jsf-skeleton-1.0.0/user';

  public signUp(firstName: string, lastName: string, email: string, password: string): void {

    this.httpClient.post(this.baseURL + '/signup', {
      firstName,
      lastName,
      email,
      password
    }).subscribe(value => console.log('registriert'));
  }

  public signIn(email: string, password: string): Observable<emailDTO> {
    return this.httpClient.post<emailDTO>(this.baseURL + '/signin', {
      email,
      password
    })
  }

  public twoFactor(code: string): Observable<ResponseDTO> {
    let email = localStorage.getItem('email');
    return this.httpClient.post<ResponseDTO>(this.baseURL + '/tfa', {
      code,
      email
    })
  }
}

interface ResponseDTO {
  token: string;
}

interface emailDTO {
  email: string;
}
