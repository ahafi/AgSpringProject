import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Parent } from '../model/parent.model';
import { ClassroomService } from '../services/classroom/classroom.service';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {
  
    public url:any;
    public parents:any;
    public currentPage:number=0;
    public currentParent:any;
    public parent:Parent=new Parent;
    public data:any;
    public size:any;
    public showMsg:boolean = false;
    public mode?:number;
    public msg:string = "";
  
  
    constructor(private service:ClassroomService, private router:Router, private activatedRoute:ActivatedRoute,private formBuilder: FormBuilder) { }
  
    ngOnInit(): void {
      this.onGetListParents();
    }
  
  
  public onGetListParents(){
     this.mode=3;
      this.service.getListParents()
      .subscribe(data=>{
        //console.log(data)
      this.parents=data;
       }, err=>{
        console.log(err);
      })
    }
  onDeleteParent(e:any){
        let conf=confirm("Etes vous sur de vouloir supprimer le parent : "+e.firstname+"?");
        if (conf)
        this.service.deleteRessource(this.service.host+"/parent/"+e.id)
        .subscribe(data=>{
          //console.log(data) 
          this.msg = "le parent "+e.firstname+" a été supprimer avec Success!";
          this.showMsg= true;
          this.onGetListParents();
          
   
        }, err=>{
          console.log(err);
        })
      }
  onEditParent(e:any){
        this.mode=4;
        this.currentParent.id = e.id;
        this.currentParent.firstname = e.firstname;
        this.currentParent.lastname = e.lastname;
        this.currentParent.email = e.email;
        this.currentParent.phone = e.phone;
      }
  
      
  public onSaveParent(data:any){
    
        this.service.saveRessource(this.service.host+"/parent",data)
        .subscribe(res=>{
         this.currentParent=res;
         console.log(res)
           this.msg = "l'enseignant "+data.firstname+" a été ajouter avec Success!"
           this.showMsg= true;
          //this.mode=1;
          this.onGetListParents();
          this.router.navigateByUrl("/parent");
         
       
        },err=>{
          console.log(err);
        })
       
        }
  
  
  onAddParent(){
        return this.mode=2;
        }
  
  onUpdateParent(value:any){ 
        this.service.updateRessource(`${this.service.host}/parent`,value)
        .subscribe(data=>{
          console.log(data);
          alert("Mise à jour effectuée avec succès");
          this.onGetListParents();
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
          this.onGetListParents();
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

