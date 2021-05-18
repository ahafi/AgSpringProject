package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.dto.UserDTO;
import com.classroom.virtualclassroom.entities.User;
import com.classroom.virtualclassroom.service.UserService;
import com.classroom.virtualclassroom.utils.HeaderUtil;


@CrossOrigin("*")
@RestController
public class UserController {


	@Autowired
	private UserService userService;
	
		
	private final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	
	
	@PostMapping(value = "/users/authenticate" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> authenticate(@RequestBody UserDTO userDTO) {
		UserDTO UserDTOAfter = new UserDTO ();
		log.info("API REST de création d'un user : {}", userDTO);
		
		// Dans le cas où l'utilisateur n'a pas de nom, on envoi une erreur
		if (userDTO.getLogin() == null) {
			log.info("probleme  : {}", userDTO);
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("UserDTO", "idexists", "A new UserDTO cannot already have an FirstName")).body(null);
		}
		try {
			UserDTOAfter = userService.authenticate(userDTO.getLogin());
			log.info("Création d'un user ok : {}", userDTO);
			if (UserDTOAfter==null){
				return new ResponseEntity<UserDTO>(HttpStatus.UNAUTHORIZED);
			}
			
			if(!userService.checkPass(userDTO.getPassword(),UserDTOAfter.getPassword())){
				return new ResponseEntity<UserDTO>(HttpStatus.UNAUTHORIZED);
			}
		
			return ResponseEntity.created(new URI("/users/authenticate"))
					.body(UserDTOAfter);
		} catch (Exception e) {	
			// TODO: handle exception
			return null;
		}
	}
	
	
	
	@PostMapping(value = "/users/register" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO UserDTOAfter = new UserDTO ();
		log.info("API REST de création d'un user : {}", userDTO);
		
		// Dans le cas où l'élève n'a pas de nom, on envoi une erreur
		if (userDTO.getLogin() == null) {
			log.info("probleme  : {}", userDTO);
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("UserDTO", "idexists", "A new UserDTO cannot already have an FirstName")).body(null);
		}else{
			if(userService.getUserByLogin(userDTO.getLogin())){
				return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("UserDTO", "idexists", "A new UserDTO can already exite")).body(null);
			 }
		}
		
		try {
			UserDTOAfter = userService.addUser(userDTO);
			log.info("Création d'un user ok : {}", UserDTOAfter);
			return ResponseEntity.created(new URI("/users/register" + UserDTOAfter.getId()))
					.headers(HeaderUtil.createEntityCreationAlert("User", UserDTOAfter.getId().toString()))
					.body(UserDTOAfter);
		} catch (Exception e) {	
			// TODO: handle exception
			return null;
		}
	}
	
	//récupérer la liste de tous les utilisateurs
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> listUsers() {
		return userService.getAll();
	}
	
	//recherche d'utilisateurs
	@PostMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<UserDTO> searshUsers(@RequestBody UserDTO userDTO) {
			List<UserDTO> listDto = new ArrayList<UserDTO>();
			if(userService.getUser(userDTO) != null){
				listDto = userService.getUser(userDTO);	
			}
			return listDto;
		}
	//mise à jour
	@PutMapping(value = "/users/update" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO UserDTOAfter = new UserDTO ();
		log.info("API REST de création d'un user : {}", userDTO);
		
		// Dans le cas où l'élève n'a pas de nom, on envoi une erreur
		if (userDTO.getLogin() == null) {
			log.info("probleme  : {}", userDTO);
			return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("UserDTO", "idexists", "A new UserDTO cannot already have an FirstName")).body(null);
		}
		try {
			UserDTOAfter = userService.updateUser(userDTO);
			log.info("Création d'un user ok : {}", UserDTOAfter);
			return ResponseEntity.created(new URI("/users/register" + UserDTOAfter.getId()))
					.headers(HeaderUtil.createEntityCreationAlert("User", UserDTOAfter.getId().toString()))
					.body(UserDTOAfter);
		} catch (Exception e) {	
			// TODO: handle exception
			return null;
		}
	}
	
	//supprimer un utilisateur
	@DeleteMapping(value = "/users/{id}")
	public String deleteUser(@PathVariable long id) {
		String msg = "";
		if(userService.delete(id)){
			msg="user supprimé";
		}else msg="user non supprimé";
		
		return msg;
	}
	
//	//ajouter un utilisateur
//		@PostMapping(value = "/utilisateurs")
//		public ResponseEntity<Void> addUser(@Valid @RequestBody User user) {
//
//			User userAdded = userRepository.save(user);
//
//			if (userAdded == null)
//				return ResponseEntity.noContent().build();
//
//			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//					.buildAndExpand(userAdded.getId()).toUri();
//
//			return ResponseEntity.created(location).build();
//		}
//		
//		// Récupérer un utilisateur par son Id
//		@GetMapping(value="/utilisateurs/{id}")
//		public User showUser(@PathVariable long id) {
//		User user = userRepository.findById(id);
//		     if(user==null) throw new NotFoundException("L'utilisateur que vous chercher est INTROUVABLE.");
//	      return user;
//	      }
//
//		
//		//recherche d'un utilisateur avec son identifiant
//		@GetMapping(value = "recherche/utilisateurs/{search}")
//		public List<User> searchUser(@PathVariable String search) {
//			return userRepository.findByLoginLike("%" + search + "%");
//		}
//
//		//mettre à jour un utilisateur
//		@PutMapping(value = "/utilisateurs")
//		public void updateUser(@RequestBody User user) {
//
//			userRepository.save(user);
//		}
//		
//		//récupérer la liste de tous les utilisateurs
//		@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
//		public List<User> listUsers() {
//
//			return userRepository.findAll(Sort.by("login").ascending());
//		}
//		

		
	
	}
	