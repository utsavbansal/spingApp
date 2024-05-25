package com.example.springApp.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentRepository.findAll();

//        return List.of(new Student
//                        (1L,"Utsav", LocalDate.of(1996, Month.JANUARY,5),"ubansal1996@gmail.com",28),
//                new Student
//                        (1L,"Vaus", LocalDate.of(1996, Month.JANUARY,5),"ubansal1@gmail.com",25));
    }


    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
                throw  new IllegalStateException("Email Taken");

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists=studentRepository.existsById(studentId);
        if(!exists)
                throw  new IllegalStateException("Student with "+ studentId+" not present");

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with id "+studentId+" does not exist")
                );
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentOptional=studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw  new IllegalStateException("Email Taken");
            }

            student.setEmail(email);
        }
        //studentRepository.save(student);
    }
}
