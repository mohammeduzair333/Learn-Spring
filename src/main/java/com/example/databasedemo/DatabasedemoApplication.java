package com.example.databasedemo;

import com.example.databasedemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DatabasedemoApplication {
    @Autowired
    StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(DatabasedemoApplication.class, args);
    }
    @PostMapping("/my-student")
    public Student PostMyStudent(@RequestBody Student student) {

        studentRepository.save(student);
        return student;

    }
    @GetMapping("/get-allstudent")
    public List<Student> ListofStudent() {
        List <Student> l=new ArrayList <>();
        Student s1 = new Student(1, 22, "uzair", 88, "bnm");
        Student s2 = new Student(2, 22, "Abhi", 88, "bnm");
        Student s3= new Student(4, 22, "jainam", 88, "bnm");
        Student s4= new Student(5, 22, "bharry", 88, "bnm");
        Student s5= new Student(5, 22, "nikith", 88, "bnm");

        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        studentRepository.saveAll(l);
        return studentRepository.findAll();

    }

}