import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {TransactionService} from "../../service/transaction.service";

@Component({
  selector: 'app-deposit-money',
  templateUrl: './deposit-money.component.html',
  styleUrls: ['./deposit-money.component.css']
})
export class DepositMoneyComponent implements OnInit {

  constructor(private formbuilder: FormBuilder, private transactionService: TransactionService) { }

 /* depositMoneyForm = this.formbuilder.group(

  )

  */



  ngOnInit(): void {
  }


  onSubmit():void {
  /*  console.log(this.depositMoneyForm.valid);
    if (this.depositMoneyForm.valid){
      this.transactionService.
        //TODO
    }

   */
  }



}
