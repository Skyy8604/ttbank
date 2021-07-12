import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth/AuthGuard';
import {ErrorComponent} from './components/error/error.component';
import {HomeTTBankComponent} from './components/home-ttbank/home-ttbank.component';
import {HomeEbankingComponent} from './components/home-ebanking/home-ebanking.component';
import {LoginComponent} from "./components/login/login.component";
import {TwoFactorAuthenticationComponent} from "./components/two-factor-authentication/two-factor-authentication.component";
import {ContactComponent} from "./components/contact/contact.component";
import {DepositMoneyComponent} from "./components/deposit-money/deposit-money.component";
import {ListHistoricCashTransactionsComponent} from "./components/list-historic-cash-transactions/list-historic-cash-transactions.component";
import {TradeComponent} from "./components/trade/trade.component";
import {TransferMoneyComponent} from "./components/transfer-money/transfer-money.component";
import {AccountTransferComponent} from "./components/account-transfer/account-transfer.component";
import {ListHisctoricTradesComponent} from "./components/list-hisctoric-trades/list-hisctoric-trades.component";
import {MyPositionsOverviewComponent} from "./components/my-positions-overview/my-positions-overview.component";

const routes: Routes = [
  {
    path: '',
    component: HomeTTBankComponent
  },
  {
    path: 'home',
    component: HomeTTBankComponent,
  },
  {
    path: 'signup',
    component: RegisterComponent
  },
  {
    path: 'signin',
    component: LoginComponent
  },
  {
    path: 'tfa',
    component: TwoFactorAuthenticationComponent
  },
  {
    path: 'home-ebanking',
    component: HomeEbankingComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'deposit-money',
    component: DepositMoneyComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'historic-cash-transactions',
    component: ListHistoricCashTransactionsComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'trade',
    component: TradeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'transfer',
    component: TransferMoneyComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'account-transfer',
    component: AccountTransferComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'historic-trades',
    component: ListHisctoricTradesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'my-positions',
    component: MyPositionsOverviewComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule{}
