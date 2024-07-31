package com.levandr.studenttechnicaltask.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "student")
public class StudentConfig {
    public boolean createOnStart;
}
