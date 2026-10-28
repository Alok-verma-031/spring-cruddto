package com.example.cruddto.dto;

import java.time.LocalDateTime;

public class UpdateStudentResponseDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollno;
    private String subject;
    private String message;
    private LocalDateTime isUpdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getIsUpdatedAt() {
        return isUpdatedAt;
    }

    public void setIsUpdatedAt(LocalDateTime isUpdatedAt) {
        this.isUpdatedAt = isUpdatedAt;
    }
}
