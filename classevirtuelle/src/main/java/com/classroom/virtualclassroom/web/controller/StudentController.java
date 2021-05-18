package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;
import com.classroom.virtualclassroom.dto.StudentDTO;
//import com.classroom.virtualclassroom.service.StudentService;
//import com.classroom.virtualclassroom.utils.HeaderUtil;
import com.classroom.virtualclassroom.service.StudentService;
import com.classroom.virtualclassroom.utils.HeaderUtil;




@CrossOrigin("*")
@RestController
public class StudentController {

	
	private final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	

	 
	 @GetMapping(value = "/eleve/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<StudentDTO>> getListEleve(@PathVariable String firstName) {
		
		 log.debug("REST request to get Eleve : {}", firstName);
		 List<StudentDTO> list = studentService.methode1(firstName);
		 log.debug("liste des eleves : {}", list);
			
	     return new ResponseEntity<>(list, HttpStatus.OK);
	 }
	 
	 /**return Optional.ofNullable(monTiers).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	  */
	 
    	//ajouter un  nouveau élève
		@PostMapping(value = "/eleves" , produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentdto) {
			StudentDTO studentDTOAfter = new StudentDTO ();
			log.debug("API REST de création d'un eleve : {}", studentdto);
			
			// Dans le cas où l'élève n'a pas de nom, on envoi une erreur
			if (studentdto.getFirstname() == null) {
				log.debug("probleme de cration : {}", studentdto);
				return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("StudentDTO", "idexists", "A new StudentDTO cannot already have an FirstName")).body(null);
			}
			try {
				studentDTOAfter = studentService.addStudent(studentdto);
				log.debug("Création d'un eleve ok : {}", studentdto);

				return ResponseEntity.created(new URI("/eleves" + studentDTOAfter.getId()))
						.headers(HeaderUtil.createEntityCreationAlert("eleves", studentDTOAfter.getId().toString()))
						.body(studentDTOAfter);
			} catch (Exception e) {	
				// TODO: handle exception
				return null;
			}
		}
		

    	//supprimer un eleve
		@DeleteMapping(value = "/eleves/{id}")
	    public void deleteStudent(@PathVariable long id) {
			studentService.delete(id);
		}


		//mettre à jour un élève
		@PutMapping(value = "/eleves")
	    public void updateStudent(@RequestBody StudentDTO studentdto) {
	        studentService.update(studentdto);
	    }

		//récupérer la liste de tous les élèves
		@GetMapping(value = "/eleves")
		 public List<StudentDTO> findAll(){
	     return studentService.findAll();
		     }
	
	}
	