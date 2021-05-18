import { DatePipe } from "@angular/common";
import { DateFormatter } from "ngx-bootstrap/datepicker";

export class Student{
  public id?:number;
  public firstname:string = "";
  public lastname:string="";
  public dateOfBirth:string="";
  public parent?:number;
  public teacher?:number;
  public classroom?:number;
}