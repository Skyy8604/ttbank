import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Transaction} from "../model/transaction.model";
import {User} from "../model/user.model";

@Injectable({
  providedIn: 'root'
})

export class TransactionService {

  constructor(private httpClient: HttpClient) {
  }

  private readonly baseURL = 'http://localhost:8080/bbc-jsf-skeleton-1.0.0/transaction';

  public loadTransactions(): Observable<Transaction[]> {
      return this.httpClient.get<Transaction[]>(this.baseURL + "/list");
  }

  /*public createTransaction(): Observable<Transaction[]>{

    return this.httpClient.post<Transaction>(this.baseURL + '/create', {

    });

  }

   */
}
