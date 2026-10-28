package com.example.cruddto.controller;

import com.example.cruddto.dto.CreateStudentRequestDto;
import com.example.cruddto.dto.CreateStudentResponseDto;
import com.example.cruddto.dto.UpdateStudentRequestDto;
import com.example.cruddto.dto.UpdateStudentResponseDto;
import com.example.cruddto.entity.Student;
import com.example.cruddto.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    // create student record
    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto createStudentRequestDto){
        CreateStudentResponseDto createdStudent=studentService.createStudent(createStudentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }
    // read One data
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getOne(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));
    }

    // read All data
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAll()
    {
        List<CreateStudentResponseDto> studentData=studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(studentData);
    }

    // update data
    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequestDto student)
    {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    // delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        studentService.studentDelete(id);
        return ResponseEntity.ok("Record delete");
    }

    // delete all
    @DeleteMapping
    public ResponseEntity<String> deleteAllStudent()
    {
        Boolean isdelete=studentService.allStudentDelete();
        if(!isdelete)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Records delete");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id)
    {
        Boolean isDeleted=studentService.deleteStudentSoftly(id);
        if(isDeleted)
        {
            return ResponseEntity.ok("Record is deleted !");
        }
        return ResponseEntity.notFound().build();
    }
}
