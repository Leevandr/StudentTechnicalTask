package com.levandr.studenttechnicaltask.Event;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {
    @EventListener
    public void handleStudentEvent(StudentEvent event) {
        System.out.println("Received students event - " + event.getMessage());
    }
}
