import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './layout/home-page/home-page.component';
import { PagesComponent } from './pages.component';

const routes: Routes = [
  {
    path: '',
    component: PagesComponent,
    children: [
      {
        path: '',
        component: HomePageComponent,
      },
    ],
  },
  // {
  //   path: 'admin',
  //   loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
  // },
  // {
  //   path: 'auth',
  //   children: [
  //     {
  //       path: '',
  //       component: LoginComponent,
  //     },
  //     {
  //       path: 'login',
  //       component: LoginComponent,
  //     },
  //   ],
  // },
  // { path: '', redirectTo: 'home', pathMatch: 'full' },
  // { path: '**', component: NotfoundComponent, },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
