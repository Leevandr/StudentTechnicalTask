package com.levandr.studenttechnicaltask.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentEvent extends ApplicationEvent {
    private final String message;

    public StudentEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
