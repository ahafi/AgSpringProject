import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { AuthentificationService } from '../services/authentification/authentification.service';


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  showMsg:boolean = false;
  msg:string = "";

  constructor(private authService:AuthentificationService, private router:Router) { }
  ngOnInit() {

  }
 onLogin(value:any) {
   //console.log(value)
this.authService.login(value.Email,value.Password);
if(this.authService.isAuthenticated){
  this.authService.saveAuthenticatedUser();
  this.router.navigateByUrl('/admin');
}else{
  this.showMsg=true;
  this.msg = "Identifiant ou mot de passe erronnés !!!"
  
}

}
// }
// onLogin(credentials:any){
// this.authetificationservice.login(credentials)
// .subscribe(res=>{
//   console.log(res)
// const token = res.id;
// localStorage.setItem('token',token);
// this.router.navigate(['admin']);
// },err=>{
//   console.log(err)
// })
forgetpwd(){
  
}

  
}
