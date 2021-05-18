import { Component, OnInit } from '@angular/core';
import { ClassroomService } from '../services/classroom/classroom.service';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import { AuthentificationService } from '../services/authentification/authentification.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})


export class AdminComponent implements OnInit {

today: number = Date.now();
public students:any;
public data:any;
constructor(private studentserv:ClassroomService,public authService:AuthentificationService, private router:Router) { }

ngOnInit(): void {}

onLogin(){
  this.router.navigateByUrl("");
}

// onGetListStudents(){
//   this.studentserv.getListStudents()
//   .subscribe(data=>{
//     this.students=data;
//    }, err=>{
//     console.log(err);
//   })
// }

// onDeleteStudent(e:any){
//   let conf=confirm("Etes vous sur de vouloir supprimer : "+e.firstname+"?");
//   let msg="l'élève "+e.firstname+"a été bien supprimer";
//   if (conf)
//   this.studentserv.deleteRessource(e._links.self.href)
//   .subscribe(data=>{
//     this.onGetListStudents();
//     alert(msg);
//   }, err=>{
//     console.log(err);
//   })
// }

// onSaveStudent(data:any){
// this.studentserv.saveRessource(this.studentserv.host+"/students",data)
// .subscribe(res=>{
// this.router.navigateByUrl("/students");
// },err=>{
//   console.log(err);
// })
// }
onLogout(){
  this.authService.removeTokenFromLocalStorage();
  this.router.navigateByUrl('');
}
}
