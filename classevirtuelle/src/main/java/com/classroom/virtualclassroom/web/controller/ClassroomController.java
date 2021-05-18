package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.classroom.virtualclassroom.dao.ClassroomRepository;
import com.classroom.virtualclassroom.entities.Classroom;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class ClassroomController {


	@Autowired
	private ClassroomRepository classroomRepository;
	
		//ajouter une classe
		@PostMapping(value = "/classes")
		public ResponseEntity<Void> addClassroom(@Valid @RequestBody Classroom classroom) {

			Classroom classroomAdded = classroomRepository.save(classroom);

			if (classroomAdded == null)
				return ResponseEntity.noContent().build();

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(classroomAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		
		// Récupérer une classe par son Id
		@GetMapping(value="/classes/{id}")
		public Classroom showClassroom(@PathVariable long id) {
		Classroom classroom = classroomRepository.findById(id);
		     if(classroom==null) throw new NotFoundException("La classe que vous chercher est INTROUVABLE.");
	      return classroom;
	      }

		//supprimer une classe
		@DeleteMapping(value = "/classes/{id}")
		public void deleteClassroom(@PathVariable long id) {

			classroomRepository.deleteById(id);
		}
		
		//rechercher une classe avec son nom
		@GetMapping(value = "recherche/classes/{search}")
		public List<Classroom> searchClassroom(@PathVariable String search) {
			return classroomRepository.findByNameLike("%" + search + "%");
		}

		//mettre à jour une classe
		@PutMapping(value = "/classes")
		public void updateClassroom(@RequestBody Classroom classroom) {

			classroomRepository.save(classroom);
		}
		
		//récupérer la liste de toutes les classes
		@RequestMapping(value = "/classes", method = RequestMethod.GET)
		public List<Classroom> listeClassrooms() {

			return classroomRepository.findAll();
		}
	
	}
	