import { Component, OnInit } from '@angular/core';
import {TransactionService} from "../../service/transaction.service";
import {Observable} from "rxjs";
import {Transaction} from "../../model/transaction.model";

@Component({
  selector: 'app-list-historic-cash-transactions',
  templateUrl: './list-historic-cash-transactions.component.html',
  styleUrls: ['./list-historic-cash-transactions.component.css']
})
export class ListHistoricCashTransactionsComponent implements OnInit {

  constructor(private transactionService: TransactionService) { }

  transactions: Observable<Transaction[]> = this.transactionService.loadTransactions();

  ngOnInit(): void {
  }

}
