import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth/AuthGuard';
import {ErrorComponent} from "./components/error/error.component";
import {HomeTTBankComponent} from "./components/home-ttbank/home-ttbank.component";

const routes: Routes = [
  {
    path: 'signup',
    component: RegisterComponent
    //canActivate: [AuthGuard] -> zugang nur wenn eingeloggt
  },
  {
    path: 'home',
    component: HomeTTBankComponent
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
