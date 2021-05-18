package com.classroom.virtualclassroom.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.classroom.virtualclassroom.dao.ClassroomRepository;
import com.classroom.virtualclassroom.dao.ParentRepository;
import com.classroom.virtualclassroom.dao.StudentRepository;
import com.classroom.virtualclassroom.dao.TeacherRepository;
import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.entities.Classroom;
import com.classroom.virtualclassroom.entities.Parent;
import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.entities.Teacher;
import com.classroom.virtualclassroom.mapper.StudentMapper;



@Transactional
@Service
public class StudentService {


	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	

	
	@Autowired
	private StudentMapper studentMapper;
	
	
	//récupérer la liste des éléve à partir de leur nom
	 public List<StudentDTO> methode1(String firstname) {
		 List<Student> list = new ArrayList<Student>();
		 list = studentRepository.findByFirstnameLike(firstname);
		 List<StudentDTO> listDto = studentMapper.listStudentToStudentDto(list);
	     return listDto;
	 }
	 
	 
	 	public boolean verifier (List<?> list) {
	 		boolean verif = false; 
	 		
	 		if(list != null && !list.isEmpty()) {
	 				verif= true; 				
	 			}
	 		return verif;
	 	}
	 
	 
		//ajouter un élève
		public StudentDTO addStudent(StudentDTO studentdto) {
			
			String parentname = studentdto.getParentName();
			String classename = studentdto.getClassroomName();
			String teachername = studentdto.getTeacherName(); 
			Student studentBefor = new Student ();
			
			studentBefor.setId(studentdto.getId());
			studentBefor.setDateOfBirth(studentdto.getDateOfBirth());
			studentBefor.setFirstname(studentdto.getFirstname());
			studentBefor.setLastname(studentdto.getLastname());
			
			List<Teacher> listTeacher = teacherRepository.findByFirstnameLike(teachername);
			
			List<Parent> listParent =  parentRepository.findByFirstnameLike(parentname); 
			
			List<Classroom> listClassroom= classroomRepository.findByNameLike(classename); 
			
			
			if (verifier(listTeacher)) {
				studentBefor.setTeacher(listTeacher.get(0));
			}
			
			if (verifier(listParent)) {
				studentBefor.setParent(listParent.get(0));
			}
			
			if (verifier(listClassroom)) {
				studentBefor.setClassroom(listClassroom.get(0));
			}
			
			Student studentAdded = studentRepository.save(studentBefor);
			 
			StudentDTO studentDTO = studentMapper.studentToStudentDto(studentAdded);

			return studentDTO;
		}
		

		//supprimer un eleve
		public void delete(@PathVariable long id) {
			studentRepository.deleteById(id);
		}

          //Mettre à jour un élève
           public StudentDTO update(StudentDTO studentdto) {
			
			String parentname = studentdto.getParentName();
			String classename = studentdto.getClassroomName();
			String teachername = studentdto.getTeacherName(); 
			Student studentBefor = new Student ();
			
			studentBefor.setId(studentdto.getId());
			studentBefor.setDateOfBirth(studentdto.getDateOfBirth());
			studentBefor.setFirstname(studentdto.getFirstname());
			studentBefor.setLastname(studentdto.getLastname());
			
			List<Teacher> listTeacher = teacherRepository.findByFirstnameLike(teachername);
			
			List<Parent> listParent =  parentRepository.findByFirstnameLike(parentname); 
			
			List<Classroom> listClassroom= classroomRepository.findByNameLike(classename); 
			
			
			if (verifier(listTeacher)) {
				studentBefor.setTeacher(listTeacher.get(0));
			}
			
			if (verifier(listParent)) {
				studentBefor.setParent(listParent.get(0));
			}
			
			if (verifier(listClassroom)) {
				studentBefor.setClassroom(listClassroom.get(0));
			}
			
			Student studentUpdate = studentRepository.save(studentBefor);
			 
			StudentDTO studentDTO = studentMapper.studentToStudentDto(studentUpdate);

			return studentDTO;
		}

		//récupérer la liste de tous les eleves
		 public List<StudentDTO> findAll() {
		 List<Student> list = new ArrayList<Student>();
		 list = studentRepository.findAll(Sort.by("firstname").ascending());
	     List<StudentDTO> listDto = studentMapper.listStudentToStudentDto(list);
		 return listDto;
		 }
		
		    
		
		
	}
	