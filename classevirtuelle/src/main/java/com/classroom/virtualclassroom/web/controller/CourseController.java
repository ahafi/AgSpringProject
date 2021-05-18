package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.classroom.virtualclassroom.dao.CourseRepository;
import com.classroom.virtualclassroom.dto.CourseDTO;
import com.classroom.virtualclassroom.entities.Course;
import com.classroom.virtualclassroom.service.CoursService;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class CourseController {


	@Autowired
	private CoursService coursService;
	
		//ajouter un coursS
//		@PostMapping(value = "/cours")
//		public ResponseEntity<Void> addCourse(@Valid @RequestBody Course course) {
//
//			Course courseAdded = courseRepository.save(course);
//
//			if (courseAdded == null)
//				return ResponseEntity.noContent().build();
//
//			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//					.buildAndExpand(courseAdded.getId()).toUri();
//
//			return ResponseEntity.created(location).build();
//		}
		
		// Récupérer un cours par son Id
		@PostMapping(value="/cours")
		public List<CourseDTO>  showCourse(@Valid @RequestBody CourseDTO dto) {
		
			List<CourseDTO> list = new ArrayList<CourseDTO>();
			
			list = coursService.getCours(dto);
			
		     if(list==null) throw new NotFoundException("La classe que vous chercher est INTROUVABLE.");
	      return list;
	      }
//
//		//supprimer un cours
//		@DeleteMapping(value = "/cours/{id}")
//		public void deleteCourse(@PathVariable long id) {
//
//			courseRepository.deleteById(id);
//		}
//		
//		//rechercher un cours avec son nom
//	//	@GetMapping(value = "recherche/cours/{search}")
//		//public List<Course> searchCourse(@PathVariable String search) {
//	//		return courseRepository.findByLevelLike("%" + search + "%");
//		//}
//
//		//mettre à jour un cours
//		@PutMapping(value = "/cours")
//		public void updateCourse(@RequestBody Course course) {
//
//			courseRepository.save(course);
//		}
//		
//		//récupérer la liste de toutes les cours
//		@RequestMapping(value = "/cours", method = RequestMethod.GET)
//		public List<Course> listeCourses() {
//
//			return courseRepository.findAll();
//		}
	
	}
	