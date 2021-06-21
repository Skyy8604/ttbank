import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

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
}

interface ResponseDTO {
  token: string;
}


