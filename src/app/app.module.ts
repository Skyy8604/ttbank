import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import {JwtModule} from '@auth0/angular-jwt';
import {ErrorComponent} from "./components/error/error.component";
import {AppRoutingModule} from "./app-routing.module";
import { HomeEbankingComponent } from './components/home-ebanking/home-ebanking.component';
import { TransferMoneyComponent } from './components/transfer-money/transfer-money.component';
import { AccountTransferComponent } from './components/account-transfer/account-transfer.component';
import { DepositMoneyComponent } from './components/deposit-money/deposit-money.component';
import { TradeComponent } from './components/trade/trade.component';
import { MyPositionsOverviewComponent } from './components/my-positions-overview/my-positions-overview.component';
import { ListHistoricCashTransactionsComponent } from './components/list-historic-cash-transactions/list-historic-cash-transactions.component';
import { ListHisctoricTradesComponent } from './components/list-hisctoric-trades/list-hisctoric-trades.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeTTBankComponent } from './components/home-ttbank/home-ttbank.component';
import { LoginComponent } from './components/login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {AlertModule} from "./components/alert";

export function tokenGetter(): any {
  return localStorage.getItem('token');
}

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ErrorComponent,
    HomeEbankingComponent,
    TransferMoneyComponent,
    AccountTransferComponent,
    DepositMoneyComponent,
    TradeComponent,
    MyPositionsOverviewComponent,
    ListHistoricCashTransactionsComponent,
    ListHisctoricTradesComponent,
    ContactComponent,
    HomeTTBankComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AlertModule,
    HttpClientModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('token');
        },
        allowedDomains: [],
        disallowedRoutes: [],
      },
    }),
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
