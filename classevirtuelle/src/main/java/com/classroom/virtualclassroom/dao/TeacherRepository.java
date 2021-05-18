package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Teacher;



@Service
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	  public List<Teacher>findAll();
	  public Teacher findById(long id);
	  @SuppressWarnings("unchecked")
      public Teacher save(Teacher teacher);
	  List<Teacher> findByFirstnameLike(String search);
	
	
}
