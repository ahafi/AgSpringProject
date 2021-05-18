package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Day;




@Service
@Repository
public interface DayRepository extends JpaRepository<Day, Long>{
	
	  public List<Day>findAll();
	  public Day findById(long id);
	  @SuppressWarnings("unchecked")
      public Day save(Day day);
	  List<Day> findByDateLike(String recherche);

}
