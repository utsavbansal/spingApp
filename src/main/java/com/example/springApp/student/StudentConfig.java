package com.example.springApp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student utsav=new Student
                        (1L,"Utsav", LocalDate.of(1996, Month.JANUARY,5),"ubansal1996@gmail.com",28);
            Student vasu=new Student
                       ("vasu", LocalDate.of(1998, Month.JANUARY,5),"ubansal@gmail.com",25);
        repository.saveAll(List.of(utsav,vasu));
        };

    }
}
