package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.*;
import com.example.service.*;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student/view/{npm}")
	public StudentModel view(@PathVariable(value="npm") String npm) {
		StudentModel student = studentService.selectStudent(npm);
		return student;
	}
	
	@RequestMapping("/student/viewall")
    public List<StudentModel> viewall (Model model)
    {
        List<StudentModel> students = studentService.selectAllStudents ();
        
//        for(int i=0; i < students.size();i++) {
//        	StudentModel student = students.get(i);
//        	return student;
//        }
        return students;
    }
	
	 @RequestMapping("/course/view/{idCourse}")
	 public CourseModel viewCoursePath (Model model,
			 @PathVariable(value = "idCourse") String idCourse)
	 {
		 CourseModel course = studentService.selectCourse (idCourse);

		 return course;
	 }

	 @RequestMapping("/course/viewall")
	 public List<CourseModel> viewCourseAll ()
	 {
		 List<CourseModel> courses = studentService.selectCourseAll ();

		 return courses;
	 }
}
