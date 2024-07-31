package com.levandr.studenttechnicaltask.shell;

import com.levandr.studenttechnicaltask.Entity.Student;
import com.levandr.studenttechnicaltask.service.StudentRepositoryImpl;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class StudentCommands {

    private final StudentRepositoryImpl studentService;

    public StudentCommands(StudentRepositoryImpl studentService) {
        this.studentService = studentService;
    }

    @ShellMethod("Add a new student")
    public void add(@ShellOption String firstName, @ShellOption String lastName, @ShellOption int age) {
        Student student = studentService.addStudent(firstName, lastName, age);
        System.out.println("Added: " + student.toString());
    }

    @ShellMethod("Remove a student by id")
    public void remove(@ShellOption Long id) {
        Student student = studentService.removeStudent(id);
        System.out.println(student != null ? "Remove student. " + student + "\nId: " + student.getId() : "Student not found");
    }

    @ShellMethod("List all students")
    public void list() {
        studentService.getAllStudents().forEach(System.out::println);
        System.out.println("It's all students");
    }

    @ShellMethod("removeAll students")
    public void removeAll() {
        studentService.removeAllStudents();
        System.out.println("All students have been removed");
    }


}
