package com.classroom.virtualclassroom.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Parent;



@Service
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{
	
	  public List<Parent>findAll();
	  public Parent findById(long id);
	  @SuppressWarnings("unchecked")
      public Parent save(Parent parent);
	  List<Parent> findByFirstnameLike(String search);
}