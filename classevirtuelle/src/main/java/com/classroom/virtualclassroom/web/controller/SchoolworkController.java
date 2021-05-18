package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.classroom.virtualclassroom.dao.SchoolworkRepository;
import com.classroom.virtualclassroom.entities.Schoolwork;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class SchoolworkController {


	@Autowired
	private SchoolworkRepository schoolworkRepository;
	
		//ajouter un devoir
		@PostMapping(value = "/devoirs")
		public ResponseEntity<Void> addSchoolwork(@Valid @RequestBody Schoolwork schoolwork) {

			Schoolwork schoolworkAdded = schoolworkRepository.save(schoolwork);

			if (schoolworkAdded == null)
				return ResponseEntity.noContent().build();

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(schoolworkAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		
		// Récupérer un devoir par son Id
		@GetMapping(value="/devoirs/{id}")
		public Schoolwork showSchoolwork(@PathVariable long id) {
		Schoolwork schoolwork = schoolworkRepository.findById(id);
		     if(schoolwork==null) throw new NotFoundException("Le devoir que vous chercher est INTROUVABLE.");
	      return schoolwork;
	      }

		//supprimer un devoir
		@DeleteMapping(value = "/devoirs/{id}")
		public void deleteSchoolwork(@PathVariable long id) {

			schoolworkRepository.deleteById(id);
		}
		
		//recherche d'un devoir avec son nom
	//	@GetMapping(value = "recherche/devoirs/{search}")
		//public List<Schoolwork> searchSchoolwork(@PathVariable String search) {
	//		return schoolworkRepository.findBySubjectLike("%" + search + "%");
		//}

		//mettre à jour un devoir
		@PutMapping(value = "/devoirs")
		public void updateSchoolwork(@RequestBody Schoolwork schoolwork) {

			schoolworkRepository.save(schoolwork);
		}
		
		//récupérer la liste de touts les devoirs
		@RequestMapping(value = "/devoirs", method = RequestMethod.GET)
		public List<Schoolwork> listSchoolworks() {

			return schoolworkRepository.findAll();
		}
	
	}
	