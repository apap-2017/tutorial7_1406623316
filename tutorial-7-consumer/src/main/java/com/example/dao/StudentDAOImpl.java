package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.model.*;

@Service
@Component
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
	@Override
	public StudentModel selectStudent(String npm) {
		// TODO Auto-generated method stub
		StudentModel student =
					restTemplate.getForObject(
							"http://localhost:8080/rest/student/view/"+npm, 
							StudentModel.class);
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		// TODO Auto-generated method stub
		List<StudentModel> students = restTemplate.getForObject("http://localhost:8080/rest/student/viewall",
				List.class);
		return students;
	}

	@Override
	public CourseModel selectCourse(String idCourse) {
		// TODO Auto-generated method stub
		CourseModel course =
				restTemplate.getForObject(
						"http://localhost:8080/rest/course/view/"+idCourse, 
						CourseModel.class);
		return course;
	}
	
}
