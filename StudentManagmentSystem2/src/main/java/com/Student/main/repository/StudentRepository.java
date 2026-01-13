package com.Student.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.main.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
