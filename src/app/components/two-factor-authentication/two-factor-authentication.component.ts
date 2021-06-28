import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {AlertService} from "../alert";
import {Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-two-factor-authentication',
  templateUrl: './two-factor-authentication.component.html',
  styleUrls: ['./two-factor-authentication.component.css']
})
export class TwoFactorAuthenticationComponent implements OnInit {

  twoFactorForm = this.formBuilder.group({
    code: ['', [Validators.required]]
  });

  constructor(private formBuilder: FormBuilder, private userService: UserService, private alertService: AlertService, private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.twoFactorForm.valid) {
      this.userService.twoFactor(this.twoFactorForm.controls.code.value).subscribe(responseDTO => {
          localStorage.setItem('token', responseDTO.token);
          localStorage.setItem('email', '');
          this.alertService.success('Sign In successful! Hello, ' + this.authService.getFName(), {
            autoClose: true,
            keepAfterRouteChange: true
          });
          this.router.navigate(['home']);
        },
        error => {
          this.alertService.error('The code you have entered is false. Please try again')
        });
    } else {
      this.alertService.error('Please fill out the form.', {
        autoClose: true,
        keepAfterRouteChange: false
      });
    }
  }

  local(): void {
    console.log(localStorage.getItem(''))
  }
}
