import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'src/app/@core/services/cookie.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private cookie: CookieService,
    private router: Router) { }

  ngOnInit(): void {
    this.onLogin();
  }

  onLogin(): void {
    const parameter: any = {
      email: 'buihoang9b8@gmail.com',
      password: 'anhhoang123'
    };
    this.userService.login(parameter).subscribe({
      next: (res: any) => {
        this.router.navigate(['/']);
      },
      error: (err: any) => {
        console.log(err);
      },
    });
    // console.log(this.cookie.getCookie('JWT_TOKEN'));
  }
}
