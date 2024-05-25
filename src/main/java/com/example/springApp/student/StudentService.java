package com.example.springApp.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    @GetMapping
    public List<Student> getStudents()
    {


        return List.of(new Student
                        (1L,"Utsav", LocalDate.of(1996, Month.JANUARY,5),"ubansal1996@gmail.com",28),
                new Student
                        (1L,"Vaus", LocalDate.of(1996, Month.JANUARY,5),"ubansal1@gmail.com",25));
    }
}
