import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IstoreService } from 'src/app/services/istore.service';
import { SearchService } from 'src/app/services/search.service';
import { UserManagementService } from 'src/app/services/user-management.service';
import { User } from 'src/app/user-management/model/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  myAuthUser!: User;
  public searchKeyword!: string;

  constructor(private userService: UserManagementService, private searchService: SearchService, private storeService: IstoreService, private router: Router) {
    this.myAuthUser = userService.getAuthUser();
  }

  ngOnInit() {
    if(!this.myAuthUser.firstName) {
      this.router.navigate(['/login']);
    }
  }

  logOut() {
    this.userService.signOutUser();
    this.router.navigate(['/']);
  }

  searchInputKeyword() {
    this.searchService.searchKeyword = this.searchKeyword;
    this.router.navigate(['/searchresult', this.searchKeyword ]);
  }

  navigateToStore(storeName: string) {
    this.storeService.storeName = storeName;
    this.router.navigate(['/istore']);
  }
}
