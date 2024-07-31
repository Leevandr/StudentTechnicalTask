package com.levandr.studenttechnicaltask.service;

import com.levandr.studenttechnicaltask.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface StudentService {

    Student addStudent(String firstName, String lastName, int age);

    Student removeStudent(Long id);

    Collection<Student> getAllStudents();

    void removeAllStudents();

}
