import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import { SharesModule } from 'src/app/shares/shares.module';

@NgModule({
  declarations: [
    HomePageComponent,
  ],
  imports: [
    CommonModule,
    SharesModule,
  ],
  exports: [
  ],
})
export class LayoutModule { }
