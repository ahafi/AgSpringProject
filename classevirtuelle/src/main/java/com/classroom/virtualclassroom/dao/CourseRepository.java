package com.classroom.virtualclassroom.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Course;

@Service
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	  public List<Course>findAll();
	  public Course findById(long id);
	  @SuppressWarnings("unchecked")
      public Course save(Course course);
	  //List<Course> findByLevelLike(String recherche);
	  
	  public Set<Course> findByClassroomName(String recherche);
	  public Set<Course> findBySubjectTitle(String recherche);
	  
}



