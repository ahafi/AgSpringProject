import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Teacher } from '../model/teacher.model';
import { ClassroomService } from '../services/classroom.service';



@Component({
  selector: 'app-newteacher',
  templateUrl: './newteacher.component.html',
  styleUrls: ['./newteacher.component.css']
})
export class NewteacherComponent implements OnInit {

  public teachers:any;
   public currentTeacher:any;

  constructor(private service:ClassroomService, private router:Router) { }

  ngOnInit(): void {
  }

  // public onGetListTeachers(){
  //   this.service.getListTeachers(this.currentPage,this.size)
  //   .subscribe(data=>{
  //     //console.log(data)
  //   this.totalPages = data["page"].totalPages;
  //   this.pages = new Array<number>(this.totalPages);
  //   this.teachers=data;
  //    }, err=>{
  //     console.log(err);
  //   })
  // } 
//   showMsg:boolean= false;
//   mode:boolean=false;
  
//  public onSaveTeacher(data:any){ 
//     this.service.saveRessource(this.service.host+"/teachers",data)
//     .subscribe(res=>{
//       //console.log(res)
//       this.currentTeacher=res;
//       this.mode=true; 
//       this.showMsg= true;
//      // this.router.navigateByUrl("enseignant");
//     //this.onGetListTeachers();
//     },err=>{
//       console.log(err);
//     })
//     }
//     public onNewTeacher(){
//       this.mode=false;
//     }
}
