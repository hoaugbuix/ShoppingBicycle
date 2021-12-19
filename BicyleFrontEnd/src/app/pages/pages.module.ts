import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';
import { NotFoundComponent } from './not-found/not-found.component';
import { HomeComponent } from './home/home.component';
import { LayoutsModule } from '../layouts/layouts.module';
import { LoginComponent } from './login/login.component';



@NgModule({
  declarations: [
    PagesComponent,
    NotFoundComponent,
    HomeComponent,
    LoginComponent,
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    LayoutsModule,
  ],
})
export class PagesModule { }
