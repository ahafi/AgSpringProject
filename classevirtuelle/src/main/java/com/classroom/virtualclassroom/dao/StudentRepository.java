package com.classroom.virtualclassroom.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.entities.Classroom;
import com.classroom.virtualclassroom.entities.Parent;
import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.entities.Teacher;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
      public List<Student> findAll();
	  public Student findById(long id);
      public Student save(StudentDTO studentdto);
      public List<Student> findByFirstnameLike(String search);
	  
      public Student findByClassroom(Classroom classroom);
      public Student findByTeacher(Teacher teacher);
      public Student findByParent(Parent parent);
	  
	  
	  
      public List<Student> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
	  
      public List<Student> findByLastname(String lastname);
	  
	  // Enabling ignoring case for an individual property
      public List<Student> findByLastnameIgnoreCase(String lastname);
	  // Enabling ignoring case for all suitable properties
      public List<Student> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

	  // Enabling static ORDER BY for a query
      public List<Student> findByLastnameOrderByFirstnameAsc(String lastname);
	  /*List<Student> findByLastnameOrderByFirstnameDesc(String lastname);
	  Page<Student> findByLastname(String lastname, Pageable pageable);
	  List<Student> findByLastname(String lastname, Sort sort);
	
	  @Query("select u from Student u where u.firstname = :firstname or u.lastname = :lastname")
	  Student findByLastnameOrFirstname(@Param("lastname") String lastname,
	                                 @Param("firstname") String firstname);*/
	
}