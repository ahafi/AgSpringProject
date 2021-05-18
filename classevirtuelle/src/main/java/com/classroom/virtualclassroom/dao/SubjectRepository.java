package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Subject;




@Service
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

	  public List<Subject>findAll();
	  public Subject findById(long id);
	  @SuppressWarnings("unchecked")
      public Subject save(Subject subject);
	  List<Subject> findByTitleLike(String recherche);
}
