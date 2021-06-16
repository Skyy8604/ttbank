import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, ValidationErrors, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signUpForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8), Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$')]],
    confirmPassword: ['', [Validators.required]],
    fName: ['', [Validators.required, Validators.minLength(2)]],
    lName: ['', [Validators.required, Validators.minLength(2)]]
  }, {validator: this.matchPassword});

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
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
