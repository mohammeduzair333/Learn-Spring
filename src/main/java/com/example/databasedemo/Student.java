package com.example.databasedemo;

import jakarta.persistence.*;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int rollno;
    @Column(name = "Age")
    int age;
    @Column(name = "Name")
    String name;
    @Column(name = "Marks")
    int marks;
    @Column(name="schoolname")
    String School;

    public Student(int rollno, int age, String name, int marks, String school) {
        this.rollno = rollno;
        this.age = age;
        this.name = name;
        this.marks = marks;
        School = school;
    }

    public Student() {

    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
}
