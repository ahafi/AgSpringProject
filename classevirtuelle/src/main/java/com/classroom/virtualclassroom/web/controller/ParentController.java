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
import org.springframework.web.bind.annotation.*;
import com.classroom.virtualclassroom.dto.ParentDTO;
import com.classroom.virtualclassroom.service.ParentService;
//import com.classroom.virtualclassroom.service.ParentService;
//import com.classroom.virtualclassroom.utils.HeaderUtil;



@CrossOrigin("*")
@RestController
public class ParentController {


	private final Logger log = LoggerFactory.getLogger(ParentController.class);

	@Autowired
	private ParentService parentService;
	

	 
	 @GetMapping(value = "/parent/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<ParentDTO>> getListParent(@PathVariable String firstName) {
		
		 log.debug("REST request to get parent : {}", firstName);
		 List<ParentDTO> list = parentService.methode1(firstName); 
		 log.debug("liste des parent : {}", list);
	     return new ResponseEntity<>(list, HttpStatus.OK);
	 }
	 
	 /**return Optional.ofNullable(monTiers).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	  */
	 
	 
    	//ajouter un  nouveau parent
		@PostMapping(value = "/parent" , produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ParentDTO> createParent(@Valid @RequestBody ParentDTO Parentdto) {
			ParentDTO ParentDTOAfter = new ParentDTO ();
			log.debug("API REST de création d'un parent : {}", Parentdto);
			
			// Dans le cas où le parent n'a pas de nom, on envoi une erreur
			if (Parentdto.getFirstname() == null) {
				log.debug("probleme de cration : {}", Parentdto);
			//	return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("ParentDTO", "idexists", "A new ParentDTO cannot already have an FirstName")).body(null);
			}
			try {
			//	ParentDTOAfter = parentService.addparent(Parentdto);
				log.debug("Création d'un eleve ok : {}", Parentdto);

				return ResponseEntity.created(new URI("/parents" + ParentDTOAfter.getId()))
				//		.headers(HeaderUtil.createEntityCreationAlert("parents", ParentDTOAfter.getId().toString()))
						.body(ParentDTOAfter);
			} catch (Exception e) {	
				// TODO: handle exception
				return null;
			}
			
		}
		

    	//supprimer un parent
		@DeleteMapping(value = "/parent/{id}")
	    public void deleteParent(@PathVariable long id) {
			parentService.delete(id);
		}


		//mettre à jour un parent
		@PutMapping(value = "/parent")
	    public void updateParent(@RequestBody ParentDTO Parentdto) {
	        parentService.update(Parentdto);
	    }

		//récupérer la liste de tous les parents
		@GetMapping(value = "/parent")
		 public List<ParentDTO> findAll(){
	     return parentService.findAll();
		     }
	
	
	}
	