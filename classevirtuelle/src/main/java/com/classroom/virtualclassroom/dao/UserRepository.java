package com.classroom.virtualclassroom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	  public List<User>findAll();
	  public User findById(long id);
	  @SuppressWarnings("unchecked")
      public User save(User user);
	  public List<User> findByLoginLike(String recherche);
	  public List<User> findByRoleLike(String recherche);
	  public List<User> findByLogin(String recherche);
	  public List<User> findByLoginAndRole(String login, String role);
}
