package com.levandr.studenttechnicaltask.service;

import com.levandr.studenttechnicaltask.entity.Student;
import com.levandr.studenttechnicaltask.event.StudentEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentRepositoryImpl implements StudentRepository {

    private final ApplicationEventPublisher eventPublisher;

    private final Map<Long, Student> students = new HashMap<>();
    private Long currentId = 1L;

    public StudentRepositoryImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    @Override
    public Student addStudent(String firstName, String lastName, int age) {
        Student student = new Student(currentId++, firstName, lastName, age);
        students.put(student.getId(), student);
        eventPublisher.publishEvent(new StudentEvent(this, "Added: " + student));
        return student;
    }

    @Override
    public Student removeStudent(Long id) {
        eventPublisher.publishEvent(new StudentEvent(this, "Removed " + id));
        return students.remove(id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public void removeAllStudents() {

        List<Long> studentIds = getAllStudents().stream()
                .map(Student::getId)
                .toList();
        studentIds.forEach(this::removeStudent);

        eventPublisher.publishEvent(new StudentEvent(this, "All students have been removed"));
    }
}
