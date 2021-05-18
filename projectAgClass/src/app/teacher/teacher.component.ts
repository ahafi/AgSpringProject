import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Teacher } from '../model/teacher.model';
import { ClassroomService } from '../services/classroom/classroom.service';




@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  public url:any;
  public teachers:any;
  public currentPage:number=0;
  public currentTeacher:any;
  public teacher:Teacher=new Teacher;
  public data:any;
  public size:any;
  public showMsg:boolean = false;
  public mode?:number;
  public msg:string = "";


  constructor(private service:ClassroomService, private router:Router, private activatedRoute:ActivatedRoute,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.onGetListTeachers();
  }


public onGetListTeachers(){
   this.mode=3;
    this.service.getListTeachers(this.currentPage,this.size)
    .subscribe(data=>{
      //console.log(data)
    this.resultSearch=this.teachers=data;
     }, err=>{
      console.log(err);
    })
  }
onDeleteTeacher(e:any){
      let conf=confirm("Etes vous sur de vouloir supprimer l'enseignant : "+e.firstname+"?");
      if (conf)    
      this.service.deleteRessource(this.service.host+"/enseignants/"+e.id)
      .subscribe(data=>{ 
        //console.log(data) 
        this.msg = "l'enseignant "+e.firstname+" a été supprimer avec Success!";
        this.showMsg= true;
        this.onGetListTeachers();
      }, err=>{
        console.log(err);
      })
    }
onEditTeacher(e:Teacher){
      this.mode=4;
      this.currentTeacher=new Teacher;
      this.currentTeacher.id = e.id;
      this.currentTeacher.firstname = e.firstname;
      this.currentTeacher.lastname = e.lastname;
      this.currentTeacher.email = e.email;
      this.currentTeacher.phone = e.phone;
      console.log(this.currentTeacher)
    }

    
public onSaveTeacher(data:any){
      this.service.saveRessource(this.service.host+"/enseignants",data)
      .subscribe(res=>{
       this.currentTeacher=res;
       console.log(res)
         this.msg = "l'enseignant "+data.firstname+" a été ajouter avec Success!"
         this.showMsg= true;
        //this.mode=1;
        this.onGetListTeachers();
        this.router.navigateByUrl("/enseignant");     
      },err=>{
        console.log(err);
      })
     
      }


onAddTeacher(){
     this.mode=2;     
     this.teacher.firstname="";
     this.teacher.lastname="";
     this.teacher.email="";
     this.teacher.phone="+33";
      }

onUpdateTeacher(value:any){ 
      this.service.updateRessource(`${this.service.host}/enseignants`,value)
      .subscribe(data=>{
        console.log(data);
        alert("Mise à jour effectuée avec succès");
        this.onGetListTeachers();
      },err=>{
        console.log(err);
      })
      }

  public search:string="";
 resultSearch:any;

onSearch(){
this.resultSearch = this.teachers.filter((teacher:Teacher)=>teacher.firstname.toLowerCase().includes(this.search.toLowerCase()));
//this.onGetListTeachers;
}

   public page = 1;
   public  count = 0;
   public  tableSize = 5;
   public  currentIndex:number=0;

      onTableDataChange(event:any){
        this.page = event;
        this.onGetListTeachers();
      }  
     
     
       
      // f = new FormGroup({
      //   firstname: new FormControl('', [Validators.required, 
      //     Validators.minLength(3)]),
      //   lastname: new FormControl('', [Validators.required, 
      //     Validators.minLength(3)]),
      //   email: new FormControl('', [Validators.required, Validators.email]),
      // });
    
      // get fm(){
      //   return this.f.controls;
      // }
    
      
    
      // submit(){
      //   console.log(this.f.value);
      // }

      
   

     }
