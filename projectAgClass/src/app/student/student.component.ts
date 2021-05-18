import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Student } from '../model/student.model';
import { ClassroomService } from '../services/classroom/classroom.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  
    public url:any;
    public students:any;
    public currentPage:number=0;
    public currentStudent:any;
    public student:Student=new Student;
    public data:any;
    public size:any;
    public showMsg:boolean = false;
    public mode?:number;
    public msg:string = "";
  
  
    constructor(private service:ClassroomService, private router:Router, private activatedRoute:ActivatedRoute,private formBuilder: FormBuilder) { }
  
    ngOnInit(): void {
      this.onGetListStudents();
    }
  
  
  public onGetListStudents(){
     this.mode=3;
      this.service.getListStudents()
      .subscribe(data=>{
        //console.log(data)
      this.students=data;
       }, err=>{
        console.log(err);
      })
    }
  onDeleteStudent(e:any){
        let conf=confirm("Etes vous sur de vouloir supprimer l'élève : "+e.firstname+"?");
        if (conf)
        this.service.deleteRessource(this.service.host+"/eleves/"+e.id)
        .subscribe(data=>{
          //console.log(data) 
          this.msg = "l'élève' "+e.firstname+" a été supprimer avec Success!";
          this.showMsg= true;
          this.onGetListStudents();
          
   
        }, err=>{
          console.log(err);
        })
      }
  onEditStudent(e:Student){
        this.mode=4;
        this.currentStudent=new Student;
        this.currentStudent.id = e.id;
        this.currentStudent.firstname = e.firstname;
        this.currentStudent.lastname = e.lastname;
        this.currentStudent.dateOfBirth = e.dateOfBirth;
        this.currentStudent.classroom = e.classroom;
        this.currentStudent.parent = e.parent;
        this.currentStudent.teacher = e.teacher;
        
      }
  
      
  public onSaveStudent(data:any){
        this.service.saveRessource(this.service.host+"/eleves",data)
        .subscribe(res=>{
         this.currentStudent=res;
         console.log(res)
           this.msg = "l'élève "+data.firstname+" a été ajouter avec Success!"
           this.showMsg= true;
          //this.mode=1;
          this.onGetListStudents();
           },err=>{
          console.log(err);
        })
       
        }
  
  
  onAddStudent(){
        return this.mode=2;
        }
  
  onUpdateStudent(value:any){ 
        this.service.updateRessource(`${this.service.host}/eleves`,value)
        .subscribe(data=>{
          //console.log(data);
          this.msg = "les données de l'élève "+value.firstname+" sont misent à jour avec Success!"
          this.showMsg= true;
          this.onGetListStudents();
        },err=>{
          console.log(err);
        })
        }
  
  
        page = 1;
        count = 0;
        tableSize = 5;
        currentIndex:number=0;
  
        onTableDataChange(event:any){
          this.page = event;
          this.onGetListStudents();
        }  

               
      f = new FormGroup({
        firstname: new FormControl('', [Validators.required, 
          Validators.minLength(3)]),
        lastname: new FormControl('', [Validators.required, 
          Validators.minLength(3)]),
        email: new FormControl('', [Validators.required, Validators.email]),
      });
    
      get fm(){
        return this.f.controls;
      }

            
}
