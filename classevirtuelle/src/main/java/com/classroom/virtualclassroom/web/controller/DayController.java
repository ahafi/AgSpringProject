package com.classroom.virtualclassroom.web.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.classroom.virtualclassroom.dao.DayRepository;
import com.classroom.virtualclassroom.entities.Day;
import com.classroom.virtualclassroom.web.exception.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RestController
public class DayController {


	@Autowired
	private DayRepository dayRepository;
	
		//ajouter un emploi du temps
		@PostMapping(value = "/jours")
		public ResponseEntity<Void> addPlanning(@Valid @RequestBody Day day) {

			Day planningAdded = dayRepository.save(day);

			if (planningAdded == null)
				return ResponseEntity.noContent().build();

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(planningAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
		
		// Récupérer un emploi du temps par son Id
		@GetMapping(value="/jours/{id}")
		public Day showDay(@PathVariable long id) {
		Day day = dayRepository.findById(id);
		     if(day==null) throw new NotFoundException("Le planning que vous chercher est INTROUVABLE.");
	      return day;
	      }

		//supprimer un emploi du temps
		@DeleteMapping(value = "/jours/{id}")
		public void deleteDay(@PathVariable long id) {

			dayRepository.deleteById(id);
		}
		
		//rechercher un emploi du temps avec son nom
		@GetMapping(value = "recherche/jours/{search}")
		public List<Day> searchDay(@PathVariable String search) {
			return dayRepository.findByDateLike("%" + search + "%");
		}

		//mettre à jour un emploi du temps
		@PutMapping(value = "/jours")
		public void updateDays(@RequestBody Day day) {

			dayRepository.save(day);
		}
		
		//récupérer la liste de tous les emploi du temps
		@RequestMapping(value = "/jours", method = RequestMethod.GET)
		public List<Day> listeDays() {

			return dayRepository.findAll();
		}
	
	}
	