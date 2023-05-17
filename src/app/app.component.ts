import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
   user: any = {};
userId: number=0;

constructor(private http: HttpClient) { }

addUser(): void {
  const url = 'http://localhost:8080/user';
  this.http.post(url, this.user)
    .subscribe(createdUser => {
      console.log('User created:', createdUser);
      
    });
}

getUser(): void {
  const url = `http://localhost:8080/user/${this.userId}`;
  this.http.get(url)
    .subscribe(user => {
      console.log('User:', user);
 
    });
}

updateUser(): void {
  const url = `http://localhost:8080/user/${this.userId}`;
  this.http.put(url, this.user)
    .subscribe(updatedUser => {
      console.log('User updated:', updatedUser);
  
    });
}

deleteUser(): void {
  const url = `http://localhost:8080/user/${this.userId}`;
  this.http.delete(url)
    .subscribe(() => {
      console.log('User deleted');
 
    });
}
}