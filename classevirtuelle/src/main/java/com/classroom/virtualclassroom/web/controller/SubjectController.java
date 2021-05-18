package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.classroom.virtualclassroom.dao.SubjectRepository;
import com.classroom.virtualclassroom.entities.Subject;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class SubjectController {


	@Autowired
	private SubjectRepository subjectRepository;
	
		//ajouter une matiere
		@PostMapping(value = "/matieres")
		public ResponseEntity<Void> addSubject(@Valid @RequestBody Subject subject) {

			Subject subjectAdded = subjectRepository.save(subject);

			if (subjectAdded == null)
				return ResponseEntity.noContent().build();

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(subjectAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		
		// Récupérer une matiere par son Id
		@GetMapping(value="/matieres/{id}")
		public Subject showSubject(@PathVariable long id) {
		Subject subject = subjectRepository.findById(id);
		     if(subject==null) throw new NotFoundException("La matiere que vous chercher est INTROUVABLE.");
	      return subject;
	      }

		//supprimer une matiere
		@DeleteMapping(value = "/matieres/{id}")
		public void deleteSubject(@PathVariable long id) {

			subjectRepository.deleteById(id);
		}
		
		//rechercher une matieres avec son nom
		@GetMapping(value = "recherche/matieres/{search}")
		public List<Subject> searchSubject(@PathVariable String search) {
			return subjectRepository.findByTitleLike("%" + search + "%");
		}

		//mettre à jour une matieres
		@PutMapping(value = "/matieres")
		public void updateSubject(@RequestBody Subject subject) {

			subjectRepository.save(subject);
		}
		
		//récupérer la liste de toutes les matieres
		@RequestMapping(value = "/matieres", method = RequestMethod.GET)
		public List<Subject> listeSubjects() {

			return subjectRepository.findAll();
		}
	
	}
	