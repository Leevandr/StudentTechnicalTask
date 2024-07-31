package com.levandr.studenttechnicaltask;

import com.levandr.studenttechnicaltask.Config.StudentConfig;
import com.levandr.studenttechnicaltask.service.StudentRepositoryImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final StudentConfig studentConfig;
    private final StudentRepositoryImpl studentService;

    public DataInitializer(StudentConfig studentConfig, StudentRepositoryImpl studentService) {
        this.studentConfig = studentConfig;
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        if (studentConfig.isCreateOnStart()) {
            studentService.addStudent("Peter", "Ivanov", 21);
            studentService.addStudent("Oleg", "Pavlov", 19);
            studentService.addStudent("Olga", "May", 25);
            System.out.println("Auto generation student is successful");
        }
    }
}

