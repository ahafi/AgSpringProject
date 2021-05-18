package com.classroom.virtualclassroom.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.classroom.virtualclassroom.dao.ClassroomRepository;
import com.classroom.virtualclassroom.dao.ParentRepository;
import com.classroom.virtualclassroom.dao.StudentRepository;
import com.classroom.virtualclassroom.dao.TeacherRepository;
import com.classroom.virtualclassroom.dto.ParentDTO;
import com.classroom.virtualclassroom.entities.Parent;
import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.mapper.ParentMapper;



@Transactional
@Service
public class ParentService {


	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	
	
	@Autowired
	private ParentMapper parentMapper;
	
	
	//récupérer la liste des parents à partir de leur nom
	 public List<ParentDTO> methode1(String firstname) {
		 List<Parent> list = new ArrayList<Parent>();
		 list = parentRepository.findByFirstnameLike(firstname);
		 List<ParentDTO> listDto = parentMapper.listParentToParentDto(list);
	     return listDto;
	 }
	 
	 
	 	public boolean verifier (List<?> list) {
	 		boolean verif = false; 
	 	if(list != null && !list.isEmpty()) {
	 				verif= true; 				
	 			}
	 		return verif;
	 	}
	 
	 
		//ajouter un parent
		public ParentDTO addparent(ParentDTO parentdto) {
			
			//String studentname = parentdto.getStudentName();
			Parent parentBefor = new Parent ();
			
			parentBefor.setId(parentdto.getId());
			parentBefor.setFirstname(parentdto.getFirstname());
			parentBefor.setLastname(parentdto.getLastname());
			parentBefor.setEmail(parentdto.getEmail());
			parentBefor.setAddress(parentdto.getAddress());
			parentBefor.setPhone(parentdto.getPhone());
			
			//List<Student> listStudent = studentRepository.findByFirstnameLike(studentname);
						
			
			
				
			Parent parentAdded = parentRepository.save(parentBefor);
			 
			ParentDTO parentDTO = parentMapper.ParentToParentDto(parentAdded);

			return parentDTO;
		}
		

		//supprimer un eleve
		public void delete(@PathVariable long id) {
			parentRepository.deleteById(id);
		}

          //Mettre à jour un élève
           public ParentDTO update(ParentDTO parentdto) {
			
			Parent parentBefor = new Parent ();
			
			parentBefor.setId(parentdto.getId());
			parentBefor.setFirstname(parentdto.getFirstname());
			parentBefor.setLastname(parentdto.getLastname());
			parentBefor.setEmail(parentdto.getEmail());
			parentBefor.setAddress(parentdto.getAddress());
			parentBefor.setPhone(parentdto.getPhone());
			
//			List<Student> listStudent = studentRepository.findByFirstnameLike(studentname);
//
//			if (verifier(listStudent)) {
//				Set<Student> stuedentSet = new HashSet<>(listStudent);
//				parentBefor.setStudents(stuedentSet);
//			}
			
						
			Parent parentUpdate = parentRepository.save(parentBefor);
			 
			ParentDTO parentDTO = parentMapper.ParentToParentDto(parentUpdate);

			return parentDTO;
		}

		//récupérer la liste de tous les eleves
		 public List<ParentDTO> findAll() {
		 List<Parent> list = new ArrayList<Parent>();
		 list = parentRepository.findAll();
	     List<ParentDTO> listDto = parentMapper.listParentToParentDto(list);
		 return listDto;
		 }
		
		    
		
		
	}
	