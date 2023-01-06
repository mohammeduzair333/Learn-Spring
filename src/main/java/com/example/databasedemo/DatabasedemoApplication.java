package com.example.databasedemo;

import com.example.databasedemo.repository.RollNo;
import com.example.databasedemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        return studentRepository.findAll();

    }

    @DeleteMapping("/delete-allstudent")
    public String deleteofStudent() {
        studentRepository.deleteAll();
        return "deleted";
    }

    @PostMapping("/delete-astudent")
    public String Studentrollno(RollNo id) {
        Optional<Student> s = studentRepository.findById(id.getId());
        if (s.isPresent()) {
            studentRepository.delete(s.get());
            return "Deleted";
        }
        return "not deleted";
    }

}

