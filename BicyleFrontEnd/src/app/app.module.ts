import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PagesModule } from './pages/pages.module';
import { LayoutsModule } from './layouts/layouts.module';
import { CoreModule } from './@core/core.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CoreModule,
    PagesModule,
    LayoutsModule,
  ],
  exports: [
    LayoutsModule,
    CoreModule,
  ],
  providers: [
    LayoutsModule,
    CoreModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
