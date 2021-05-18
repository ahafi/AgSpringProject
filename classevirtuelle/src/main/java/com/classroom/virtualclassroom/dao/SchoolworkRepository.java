package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Schoolwork;



@Service
@Repository
public interface SchoolworkRepository extends JpaRepository<Schoolwork, Long>{

	  public List<Schoolwork>findAll();
	  public Schoolwork findById(long id);
	  @SuppressWarnings("unchecked")
      public Schoolwork save(Schoolwork schoolwork);
	  //List<Schoolwork> findBySubjectLike(String recherche);
}
