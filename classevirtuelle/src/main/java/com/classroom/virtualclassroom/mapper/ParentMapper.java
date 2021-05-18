package com.classroom.virtualclassroom.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.stereotype.Component;

import com.classroom.virtualclassroom.dto.ParentDTO;
import com.classroom.virtualclassroom.entities.Parent;





@Component
@Mapper(componentModel = "spring" , uses = {})
public abstract class ParentMapper {
	
	 //@Mapping(source = "studentId", target = "studentName", qualifiedByName = "studentName")
	 public  abstract ParentDTO ParentToParentDto(Parent parent);

	 
	 public abstract List<ParentDTO> listParentToParentDto(List<Parent> ParentList);
	 
	 //@Mapping(target="students", ignore=true)
	 public  abstract Parent ParentDtoToParent(ParentDTO dto);
	
	 public abstract List<Parent> listTeacherDtoToParent(List<ParentDTO> ParentList);

	
	 }


