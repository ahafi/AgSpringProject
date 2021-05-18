package com.classroom.virtualclassroom.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.entities.Student;







@Component
@Mapper(componentModel = "spring" , uses = {})
public abstract class StudentMapper {
	
	 @Mapping(source = "teacher.firstname", target = "teacherName")
	 @Mapping(source = "parent.firstname", target = "parentName")
	 @Mapping(source = "classroom.name", target = "classroomName")
	 public  abstract StudentDTO studentToStudentDto(Student student);
	 
	 public abstract List<StudentDTO> listStudentToStudentDto(List<Student> StudentList);
	 
	
	    
//	 @Mapping(source = "teacherName", target = "teacher.firstname")
//	 @Mapping(source = "parentName", target = "parent.firstname")
//	 @Mapping(source = "classeName", target = "classroom.name")
	 //@Mapping(target = "dateOfBirth", expression = "java(new java.util.Date())", dateFormat = "yyyy-MM-dd")
	 @Mapping(target="teacher", ignore=true)
	 @Mapping(target="parent", ignore=true)
	 @Mapping(target="classroom", ignore=true)
	 public  abstract Student studentDtoToStudent(StudentDTO dto);
	
	 public abstract List<Student> listStudentDtoToStudent(List<StudentDTO> StudentList);

	
	 }


