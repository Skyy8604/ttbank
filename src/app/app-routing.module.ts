import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth/AuthGuard';
import {ErrorComponent} from './components/error/error.component';
import {HomeTTBankComponent} from './components/home-ttbank/home-ttbank.component';
import {HomeEbankingComponent} from './components/home-ebanking/home-ebanking.component';
import {LoginComponent} from "./components/login/login.component";

const routes: Routes = [
  {
    path: '',
    component: HomeTTBankComponent
  },
  {
    path: 'home',
    component: HomeTTBankComponent,
    // canActivate: [AuthGuard] -> beispiel
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
    path: 'home-ebanking',
    component: HomeEbankingComponent
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
