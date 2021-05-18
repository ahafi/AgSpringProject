import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from '../../model/teacher.model';


@Injectable({
  providedIn: 'root'
})
export class ClassroomService {

public host:string = "http://localhost:8080";

public data:any
  constructor(private http:HttpClient) { }

public getListTeachers(page:number,size:number){
    return this.http.get(this.host+"/enseignants");
}
// public getTeachersByName(url:any, data:any){
//   return this.http.get(this.host+"/enseignants"+data)
//                  .map(res=>res.json());
// }
public getListUsers(){
      return this.http.get(this.host+"/utilisateurs");
    
  }
public getListParents(){
    return this.http.get(this.host+"/parent");
    
  }

public getListStudents(){
    return this.http.get(this.host+"/eleves");
    
  }

public deleteRessource(url:any){
    return this.http.delete(url);
  }
public saveRessource(url:any, data:any){
    return this.http.post(url,data);
  }

public getRessource(url:any){
    return this.http.get(url);
  }

public updateRessource(url:any,data:any){
    return this.http.put(url,data);
  }
}
