import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from '../../pages/login/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private cookie: CookieService) { }

  ngOnInit(): void {
    this.getUserLogin();
  }


  getUserLogin() {
    const params = {
      'email': 'buihoang9b8@gmail.com',
      'password': 'anhhoang123'
    };
    this.userService.login(params).subscribe({
      next: (data) => {
        console.log(data);
      }, error: (err) => {
        console.log(err);
      },
    });

  }

}
