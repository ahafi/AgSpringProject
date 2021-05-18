package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.classroom.virtualclassroom.dao.TeacherRepository;
import com.classroom.virtualclassroom.entities.Teacher;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class TeacherController {


	@Autowired
	private TeacherRepository teacherRepository;
	
		//ajouter un enseignant
		@PostMapping(value = "/enseignants")
		public ResponseEntity<Void> addTeacher(@Valid @RequestBody Teacher teacher) {

			Teacher teacherAdded = teacherRepository.save(teacher);

			if (teacherAdded == null)
				return ResponseEntity.noContent().build();

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(teacherAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		
		// Récupérer un enseignant par son Id
		@GetMapping(value="/enseignants/{id}")
		public Teacher showTeacher(@PathVariable long id) {
		Teacher teacher = teacherRepository.findById(id);
		     if(teacher==null) throw new NotFoundException("L'enseignant que vous chercher est INTROUVABLE.");
	      return teacher;
	      }

		//supprimer un enseignant
		@DeleteMapping(value = "/enseignants/{id}")
		public void deleteTeacher(@PathVariable Long id) {

			teacherRepository.deleteById(id);
		}
		
		//rechercher un enseignant avec son nom
		@GetMapping(value = "recherche/enseignants/{search}")
		public List<Teacher> searchTeacher(@PathVariable String search) {
			return teacherRepository.findByFirstnameLike("%" + search + "%");
		}

		//mettre à jour un enseignant
		@PutMapping(value = "/enseignants")
		public void updateTeacher(@RequestBody Teacher teacher) {
			teacherRepository.save(teacher);
		}
		
		// récupérer la liste de tous les enseignants
		//public List<Teacher> Teachers(){
			//return teacherRepository.findAll();
		//}		
		@RequestMapping(value = "/enseignants", method = RequestMethod.GET)
		public List<Teacher> teachers(){ 
		return teacherRepository.findAll(Sort.by("firstname").ascending());
		}

			}
	