package com.classroom.virtualclassroom.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.classroom.virtualclassroom.dao.ClassroomRepository;
import com.classroom.virtualclassroom.dao.CourseRepository;
import com.classroom.virtualclassroom.dao.ParentRepository;
import com.classroom.virtualclassroom.dao.StudentRepository;
import com.classroom.virtualclassroom.dao.SubjectRepository;
import com.classroom.virtualclassroom.dao.TeacherRepository;
import com.classroom.virtualclassroom.dao.UserRepository;
import com.classroom.virtualclassroom.dto.CourseDTO;
import com.classroom.virtualclassroom.dto.StudentDTO;
import com.classroom.virtualclassroom.dto.UserDTO;
import com.classroom.virtualclassroom.entities.Classroom;
import com.classroom.virtualclassroom.entities.Course;
import com.classroom.virtualclassroom.entities.Parent;
import com.classroom.virtualclassroom.entities.Student;
import com.classroom.virtualclassroom.entities.Subject;
import com.classroom.virtualclassroom.entities.Teacher;
import com.classroom.virtualclassroom.entities.User;
import com.classroom.virtualclassroom.mapper.StudentMapper;
import com.classroom.virtualclassroom.mapper.UserMapper;
import com.classroom.virtualclassroom.web.controller.StudentController;

@Transactional
@Service
public class CoursService {

	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	private final Logger log = LoggerFactory.getLogger(StudentController.class);

	

	//get cours
		public List<CourseDTO> getCours(CourseDTO courseDTO) {
			
			List<Course> listcourseAdd = new ArrayList<>();
			List<CourseDTO> list = new ArrayList<CourseDTO>();
			
			Set <Course> setcourse1 = new HashSet<Course>();
			Set <Course> setcourse2 = new HashSet<Course>();
			
			if(courseDTO.getClassroomName()!=null ){
				setcourse1 = courseRepository.findByClassroomName(courseDTO.getClassroomName());
			}
			
			if(courseDTO.getSubjectTitle()!=null){
				setcourse2 = courseRepository.findBySubjectTitle(courseDTO.getSubjectTitle());
			}
				
				if (setcourse1 !=null && !setcourse1.isEmpty() && setcourse2 !=null && !setcourse2.isEmpty() ){
							List<Course> listcourse1 = new ArrayList<>(setcourse1);
							List<Course> listcourse2 = new ArrayList<>(setcourse2);
							
							listcourseAdd = listcourse1.stream()
						            .filter(element -> listcourse2.contains(element))
						            .collect(Collectors.toList());
						}else if(setcourse1 !=null && !setcourse1.isEmpty() && courseDTO.getSubjectTitle().isEmpty()){
							List<Course> listcourse1 = new ArrayList<>(setcourse1);
							listcourseAdd = listcourse1.stream()
						            .collect(Collectors.toList());
							
						}else if(setcourse2 !=null && !setcourse2.isEmpty() && courseDTO.getClassroomName().isEmpty()){
							List<Course> listcourse2 = new ArrayList<>(setcourse2);
							listcourseAdd = listcourse2.stream()
						            .collect(Collectors.toList());
						}
			
			if (listcourseAdd!=null && !listcourseAdd.isEmpty()){
				for ( Course cr : listcourseAdd){
					CourseDTO dto = new CourseDTO();
					dto.setClassroomName(cr.getClassroom().getName());
					dto.setSubjectTitle(cr.getSubject().getTitle());
					dto.setStartTime(cr.getStartTime());
					dto.setEndTime(cr.getEndTime());
					dto.setDayDate(cr.getDay().getDate());
					list.add(dto);
				}
			}
			return list;
		}
	
	
	
	

	

}
