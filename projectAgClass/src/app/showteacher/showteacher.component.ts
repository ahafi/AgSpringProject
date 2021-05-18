import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from '../model/teacher.model';
import { ClassroomService } from '../services/classroom.service';

@Component({
  selector: 'app-showteacher',
  templateUrl: './showteacher.component.html',
  styleUrls: ['./showteacher.component.css']
})
export class ShowteacherComponent implements OnInit {

public currentTeacher:any;
public teachers:any;
public url:any;
  constructor(private router:Router, private activatedRoute:ActivatedRoute, private service:ClassroomService) { }

  ngOnInit(){
   this.url = atob(this.activatedRoute.snapshot.params.id);
    this.service.getRessource(this.url)
    .subscribe(data=>{
      this.currentTeacher=data;
    }, err=>{
      console.log(err);
    })
  }
  onUpdateTeacher(value:any){ 
    this.service.updateRessource(this.url,value)
    .subscribe(data=>{
      //console.log(data);
      alert("Mise à jour effectuée avec succès");
     this.router.navigateByUrl("/enseignant")
    },err=>{
      console.log(err);
    })
    }
 
}
