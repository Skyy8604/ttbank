import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";
import {AlertService} from "../alert";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  signInForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8), Validators.pattern('(?=.*[A-Z]+)(?=.*[0-9]+).{8,}')]]
  });

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router, private alertService: AlertService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.signInForm.valid) {
      this.userService.signIn(this.signInForm.controls.email.value, this.signInForm.controls.password.value).subscribe(value => {
          localStorage.setItem('email', value.email);
          this.router.navigate(['/tfa']);
        },
        error => {
          if (error.status == 401) {
            this.alertService.error('Unfortunately we couldn\'t find an account with the credentials you\'ve entered :(. Please try again or register a new account.');
          } else {
            this.alertService.error('Something went wrong while you were logging in. Please try again. If this problem persists please contact our support. Error: ' + error.status);
          }
        })
    } else {
      this.alertService.error('The values you have entered are invalid.', {
        autoClose: true,
        keepAfterRouteChange: false
      })
    }
  }
}
