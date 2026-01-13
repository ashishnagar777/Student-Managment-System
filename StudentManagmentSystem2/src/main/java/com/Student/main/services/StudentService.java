package com.Student.main.services;

import java.util.List;

import com.Student.main.entities.Student;

public interface StudentService {
	
	
List<Student> getAllStudent(); 

public Student saveStudent(Student student); 

public Student getStudentyId(int id);

public void deleteById(int id);
}
