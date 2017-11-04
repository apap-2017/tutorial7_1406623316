package com.example.dao;

import java.util.*;

import com.example.model.*;

public interface StudentDAO {
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudents();
	CourseModel selectCourse(String idCourse);
}
