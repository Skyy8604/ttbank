import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from './components/register/register.component';
import {AuthGuard} from './auth/AuthGuard';
import {ErrorComponent} from "./components/error/error.component";

const routes: Routes = [
  {
    path: 'signup',
    component: RegisterComponent
    //canActivate: [AuthGuard] -> zugang nur wenn eingeloggt
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
