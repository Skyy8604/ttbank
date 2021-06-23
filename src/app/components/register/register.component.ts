import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, ValidationErrors, Validators} from "@angular/forms";
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";
import {AlertService} from "../alert";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signUpForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8), Validators.pattern('(?=.*[A-Z]+)(?=.*[0-9]+).{8,}')]],
    confirmPassword: ['', [Validators.required]],
    fName: ['', [Validators.required, Validators.minLength(2)]],
    lName: ['', [Validators.required, Validators.minLength(2)]],
    checkbox: ['', [Validators.required]]
  }, {validator: this.matchPassword});

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router, private alertService: AlertService) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.signUpForm.valid) {
      this.userService.signUp(this.signUpForm.controls.fName.value, this.signUpForm.controls.lName.value,
        this.signUpForm.controls.email.value, this.signUpForm.controls.password.value);
      this.alertService.success('You have successfully been registered!', {
        autoClose: true,
        keepAfterRouteChange: true
      });
      this.router.navigate(['/home']);
    } else {
      this.alertService.error('Registration Failed. You haven\'t filled out the form correctly.', {
        autoClose: false,
        keepAfterRouteChange: false
      })
    }
  }


  matchPassword(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;

    if (password != confirmPassword) {
      return {'noMatch': true}
    }

    return null;
  }

}
