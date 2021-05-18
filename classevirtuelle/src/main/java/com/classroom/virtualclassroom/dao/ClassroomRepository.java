package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Classroom;

@Service
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

	  public List<Classroom>findAll();
	  public Classroom findById(long id);
	  
	 
	  @SuppressWarnings("unchecked")
      public Classroom save(Classroom classroom);
	  public List<Classroom> findByNameLike(String recherche);
}
