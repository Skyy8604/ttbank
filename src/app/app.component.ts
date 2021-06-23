import {Component} from '@angular/core';
import {AuthService} from "./service/auth.service";
import {AlertService} from "./components/alert";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TTBank';

  constructor(public authService: AuthService, private alertService: AlertService) {
  }

  public signOut(): void {
    localStorage.setItem('token', '');
    this.alertService.success('You have been signed out successfully! See you soon.', {
      autoClose: true,
      keepAfterRouteChange: true
    });
  }

  public isLoggedIn(): boolean {
    return this.authService.authorizeToken();
  }
}
