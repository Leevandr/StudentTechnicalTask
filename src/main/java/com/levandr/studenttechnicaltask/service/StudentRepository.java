package com.levandr.studenttechnicaltask.service;

import com.levandr.studenttechnicaltask.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository {

    Student addStudent(String firstName, String lastName, int age);

    Student removeStudent(Long id);

    Collection<Student> getAllStudents();

    void removeAllStudents();

}
