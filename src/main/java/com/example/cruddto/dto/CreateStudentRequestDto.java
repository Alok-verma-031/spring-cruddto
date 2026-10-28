package com.example.cruddto.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "Name can not be null and empty !")
    @Size(min = 2,max = 50,message = "Student name must be within 2 to 50 character long !")
    private String name;

    @NotNull(message = "Age is required !")
    @Min(value = 18, message = "Student must be at least 18 year old !")
    private Integer age;
    @NotBlank(message = "Student email cannot be blank !")
    @Email(message = "email must be valid !")
    private String email;
    @NotNull(message = "RollNO is required !")
    private Integer rollno;

    @NotBlank
    private String subject;


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
}
