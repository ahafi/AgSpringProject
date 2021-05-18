import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClassroomService } from '../classroom/classroom.service';

@Injectable({
  providedIn: 'root'
})


export class AuthentificationService {

private users=[
  {email:'admin',password:'1234',roles:'ADMIN'},
  {email:'enseignnant',password:'1234',roles:'ENSEIGNANT'},
  {email:'parent',password:'1234',roles:'PARENT'}
];

public isAuthenticated:boolean=true;
private userAuthenticated:any;
public token:any;

  constructor(private http:HttpClient, private service:ClassroomService) { }

 
  // public onGetListUsers(){
  //    this.service.getListUsers()
  //    .subscribe(data=>{
  //      //console.log(data)
  //    this.users=data;
  //     }, err=>{
  //      console.log(err);
  //    })
  //  }




  public login(email:string,password:string){
    let user;
    
    this.users.forEach(u=>{
      if(u.email==email && u.password==password){
        user=u;
        this.token= btoa(JSON.stringify({email:u.email,roles:u.roles}))
         }
    });
    if(user){
      this.isAuthenticated=true;
      this.userAuthenticated=user;
    }
    else{
      this.isAuthenticated=false;
      this.userAuthenticated=undefined;
    }
  }
public isAdmin(){
  if(this.userAuthenticated){
    if(this.userAuthenticated.roles=='ADMIN')
    return true;
  }
  return false;
}
  
public saveAuthenticatedUser(){
  if(this.userAuthenticated){
    localStorage.setItem('authToken', this.token);
  }
}
public loadAntheticatedFromLocalStorage(){
  let t=localStorage.getItem('authToken');
  if(t){
  let user = JSON.parse(atob(t));
  this.userAuthenticated = {email:user.email,roles:user.roles};
  this.isAuthenticated=true;
  this.token=t;
}
}
public removeTokenFromLocalStorage(){
  localStorage.removeItem('authToken');
  this.isAuthenticated=false;
  this.token=undefined;
  this.userAuthenticated=undefined;

}
}

  ​
  







