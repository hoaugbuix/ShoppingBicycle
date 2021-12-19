import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CookieService } from './services/cookie.service';
import { AuthService } from './services/auth.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [CookieService, AuthService],
})
export class CoreModule { }
