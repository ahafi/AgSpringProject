package com.classroom.virtualclassroom.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.classroom.virtualclassroom.dto.UserDTO;
import com.classroom.virtualclassroom.entities.User;

@Component
@Mapper(componentModel = "spring" , uses = {})
public abstract class UserMapper {
	
	 //@Mapping(source = "classroom.name", target = "classroomName")
	 public  abstract UserDTO userToUserDto(User user);
	 public abstract List<UserDTO> listUserToUserDto(List<User> userList);
	 
	// @Mapping(target="classroom", ignore=true)
	 public  abstract User userDtoToUser(UserDTO dto);
	 public abstract List<User> listUserDtoToUser(List<UserDTO> userList);
	
	 }


