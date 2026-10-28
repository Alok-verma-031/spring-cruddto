package com.example.cruddto.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="student_dto")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollno;
    private String subject;
    private boolean deleted;
    private LocalDateTime isCreatedAt;
    private LocalDateTime isUpdatedAt;

    public LocalDateTime getIsCreatedAt() {
        return isCreatedAt;
    }

    public void setIsCreatedAt(LocalDateTime isCreatedAt) {
        this.isCreatedAt = isCreatedAt;
    }

    public LocalDateTime getIsUpdatedAt() {
        return isUpdatedAt;
    }

    public void setIsUpdatedAt(LocalDateTime isUpdatedAt) {
        this.isUpdatedAt = isUpdatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
