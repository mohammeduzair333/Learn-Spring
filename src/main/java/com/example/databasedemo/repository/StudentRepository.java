package com.example.databasedemo.repository;

import com.example.databasedemo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//repository is talking to database
public interface StudentRepository extends JpaRepository <Student, Long>{

}

