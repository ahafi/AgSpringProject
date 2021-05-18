package com.classroom.virtualclassroom.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.classroom.virtualclassroom.dao.ClassroomRepository;
import com.classroom.virtualclassroom.dao.ParentRepository;
import com.classroom.virtualclassroom.dao.StudentRepository;
import com.classroom.virtualclassroom.dao.TeacherRepository;
import com.classroom.virtualclassroom.dao.UserRepository;
import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.dto.UserDTO;
import com.classroom.virtualclassroom.entities.Classroom;
import com.classroom.virtualclassroom.entities.Parent;
import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.entities.Teacher;
import com.classroom.virtualclassroom.entities.User;
import com.classroom.virtualclassroom.mapper.StudentMapper;
import com.classroom.virtualclassroom.mapper.UserMapper;
import com.classroom.virtualclassroom.web.controller.StudentController;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;
	
	private final Logger log = LoggerFactory.getLogger(StudentController.class);

	
	//get all users
	public List<UserDTO> getAll() {
		List<User> list = new ArrayList<User>();
		list = userRepository.findAll(Sort.by("login").ascending());
		List<UserDTO> listDto = userMapper.listUserToUserDto(list);
		return listDto;
	}
	
	
	//get users
		public List<UserDTO> getUser(UserDTO userDTO) {
			List<User> list = new ArrayList<User>();
			if(userDTO.getLogin()!=null && userDTO.getRole()!=null && !userDTO.getLogin().isEmpty() && !userDTO.getRole().isEmpty()){
				list = userRepository.findByLoginAndRole(userDTO.getLogin(),userDTO.getRole());
			}else{
				if(userDTO.getLogin()!=null && !userDTO.getLogin().isEmpty()){
					list = userRepository.findByLoginLike(userDTO.getLogin());
				}else{
					list = userRepository.findByRoleLike(userDTO.getRole());
				}
			}
			
			if(list==null && list.isEmpty()){
				return null;
			}
			
			List<UserDTO> listDto = userMapper.listUserToUserDto(list);
			return listDto;
		}
		
		
		public boolean getUserByLogin(String login) {
			boolean existe=false;
			List<User> list = new ArrayList<User>();
			list = userRepository.findByLogin(login);
			if(list!=null && !list.isEmpty()){
				existe = true;
			}
			return existe;
		}
	
	
	// get user by login
	public UserDTO authenticate(String login) {
		List<User> list = new ArrayList<User>();
		list = userRepository.findByLoginLike(login);
		if(list==null && list.isEmpty()){
			return null;
		}
		List<UserDTO> listDto = userMapper.listUserToUserDto(list);
		
		return listDto.get(0);
	}

	// add user
	public UserDTO addUser(UserDTO userDTO) {
		// encrypt password
		String password = hashPassword(userDTO.getPassword());
		User userBefor = new User();
		userBefor = userMapper.userDtoToUser(userDTO);
		userBefor.setPassword(password);
		User userAdded = userRepository.save(userBefor);
		UserDTO userDTOF = userMapper.userToUserDto(userAdded);
		return userDTOF;
	}
	
	
	// update user
		public UserDTO updateUser(UserDTO userDTO) {
			// encrypt password
			User userBefor = new User();
			userBefor = userRepository.getOne(userDTO.getId()); 
			String password ="";
			boolean pass = false;
			if(!userDTO.getPassword().equals(userBefor.getPassword())){
				pass = true;
				password = hashPassword(userDTO.getPassword());
			}
			userBefor.setLogin(userDTO.getLogin());
			userBefor.setRole(userDTO.getRole());
			if(pass){
				userBefor.setPassword(password);
			}
			
			User userAdded = userRepository.save(userBefor);
			UserDTO userDTOF = userMapper.userToUserDto(userAdded);
			return userDTOF;
		}
	
		
		 //supprimer un user
		 public boolean delete(long id) {
			 boolean delete =false;
			 User userToDelete = new User();
			 userToDelete = userRepository.findById(id);
			 if(userToDelete != null){
				 userRepository.delete(userToDelete);
				 //userRepository.deleteById(id);
				 delete=true;
			 }
			 return delete;
		 }
		
	public boolean checkPass(String plainPassword, String hashedPassword) {
		boolean check = false;
		if (BCrypt.checkpw(plainPassword, hashedPassword)){
			System.out.println("The password matches.");
			check=true;
			log.info("The password matches. : {}", plainPassword);
		}
		else{
			System.out.println("The password does not match.");
			log.info("The password matches. : {}", plainPassword);
		}
		return check;
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	private boolean verifier(List<?> list) {
		boolean verif = false;

		if (list != null && !list.isEmpty()) {
			verif = true;
		}
		return verif;
	}

	//
	//
	// //supprimer un eleve
	// public void delete(@PathVariable long id) {
	// studentRepository.deleteById(id);
	// }
	//
	// //Mettre à jour un élève
	// public StudentDTO update(StudentDTO studentdto) {
	//
	// String parentname = studentdto.getParentName();
	// String classename = studentdto.getClassroomName();
	// String teachername = studentdto.getTeacherName();
	// Student studentBefor = new Student ();
	//
	// studentBefor.setId(studentdto.getId());
	// studentBefor.setDateOfBirth(studentdto.getDateOfBirth());
	// studentBefor.setFirstname(studentdto.getFirstname());
	// studentBefor.setLastname(studentdto.getLastname());
	//
	// List<Teacher> listTeacher =
	// teacherRepository.findByFirstnameLike(teachername);
	//
	// List<Parent> listParent =
	// parentRepository.findByFirstnameLike(parentname);
	//
	// List<Classroom> listClassroom=
	// classroomRepository.findByNameLike(classename);
	//
	//
	// if (verifier(listTeacher)) {
	// studentBefor.setTeacher(listTeacher.get(0));
	// }
	//
	// if (verifier(listParent)) {
	// studentBefor.setParent(listParent.get(0));
	// }
	//
	// if (verifier(listClassroom)) {
	// studentBefor.setClassroom(listClassroom.get(0));
	// }
	//
	// Student studentUpdate = studentRepository.save(studentBefor);
	//
	// StudentDTO studentDTO = studentMapper.studentToStudentDto(studentUpdate);
	//
	// return studentDTO;
	// }
	//
	// //récupérer la liste de tous les eleves
	// public List<StudentDTO> findAll() {
	// List<Student> list = new ArrayList<Student>();
	// list = studentRepository.findAll();
	// List<StudentDTO> listDto = studentMapper.listStudentToStudentDto(list);
	// return listDto;
	// }

}
