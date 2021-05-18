import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from '../model/teacher.model';


@Injectable({
  providedIn: 'root'
})
export class ClassroomService {

  public host:string = "http://localhost:8080";
public data:any
  constructor(private http:HttpClient) { }

  public getListTeachers(page:number,size:number){
    return this.http.get(this.host+"/teachers?page="+page+"&size="+size);
    
  }
  public getListParents(){
    return this.http.get(this.host+"/parents");
    
  }

  public getListStudents(){
    return this.http.get(this.host+"/students");
    
  }

 deleteRessource(url:any){
    return this.http.delete(url);
  }
public saveRessource(url:any, data:any):Observable<Teacher>{
    return this.http.post(url,data);
  }

public getRessource(url:any):Observable<Teacher>{
    return this.http.get(url);
  }

  public updateRessource(url:any,data:any):Observable<Teacher>{
    return this.http.put<Teacher>(url,data);
  }
}
