import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PagesModule } from './pages/pages.module';
import { SharesModule } from './shares/shares.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PagesModule,
    SharesModule,
  ],
  exports: [
    SharesModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
