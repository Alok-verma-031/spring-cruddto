package com.example.cruddto.service;

import com.example.cruddto.dto.CreateStudentRequestDto;
import com.example.cruddto.dto.CreateStudentResponseDto;
import com.example.cruddto.dto.UpdateStudentRequestDto;
import com.example.cruddto.dto.UpdateStudentResponseDto;
import com.example.cruddto.entity.Student;
import com.example.cruddto.exception.DuplicateResourceException;
import com.example.cruddto.exception.ResourceNotFoundException;
import com.example.cruddto.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepo srepo;
    public StudentService(StudentRepo srepo)
    {
        this.srepo=srepo;
    }
    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReq)
    {
        Student student=mapToEntity(studentReq);
        if(srepo.existsByEmail(student.getEmail()))
        {
            throw new DuplicateResourceException("Email already Exists");
        }
        Student studentRes =srepo.save(student);
        CreateStudentResponseDto studentRespo=mapToDto(studentRes);
        return studentRespo;
    }



    public CreateStudentResponseDto getStudent(Long id)
    {
        Student studentResp=srepo
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" Not Found !"));
        return mapToDto(studentResp);
    }

    public List<CreateStudentResponseDto> getAllStudent()
    {
//        List<Student> allstudentResp=studentRepository.findAll();
        List<Student> allstudentResp=srepo.findByDeletedIsFalse();
        List<CreateStudentResponseDto> response=new ArrayList<>();
        for(Student sturepo:allstudentResp)
        {
           CreateStudentResponseDto dto= mapToDto(sturepo);
           response.add(dto);
        }
        return response;
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto student)
    {
            Student studentToSave=srepo.findByIdAndDeletedIsFalse(id)
                    .orElseThrow(()->new ResourceNotFoundException("Student was not found"));
            studentToSave.setName(student.getName());
            studentToSave.setRollno(student.getRollno());
            studentToSave.setAge(student.getAge());
            studentToSave.setSubject(student.getSubject());
            Student updatedStudent=srepo.save(studentToSave);
            UpdateStudentResponseDto studentrespo=mapToUpdatedDto(updatedStudent);
            return studentrespo;
    }

    public void studentDelete(Long id)
    {
        srepo.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student was not found"));
        srepo.deleteById(id);

    }

    public boolean allStudentDelete()
    {
        if (srepo.count() > 0) {
            srepo.deleteAll();
            return true;
        }
        return false;
    }

    public Boolean deleteStudentSoftly(Long id)
    {
        Optional<Student> existStudent=srepo.findByIdAndDeletedIsFalse(id);
        if(existStudent.isEmpty())
        {
            return false;
        }
        Student studentToSave=existStudent.get();
        studentToSave.setDeleted(true);
        srepo.save(studentToSave);
        return true;
    }


    // map To Entity
    private Student mapToEntity(CreateStudentRequestDto studentReq) {
        Student student=new Student();
        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());
        student.setRollno(studentReq.getRollno());
        student.setSubject(studentReq.getSubject());

        student.setDeleted(false);
        student.setIsCreatedAt(LocalDateTime.now());
        student.setIsUpdatedAt(LocalDateTime.now());
        return student;
    }

    // map to dto
    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto studentRespo=new CreateStudentResponseDto();
        studentRespo.setId(student.getId());
        studentRespo.setName(student.getName());
        studentRespo.setEmail(student.getEmail());
        studentRespo.setAge(student.getAge());
        studentRespo.setRollno(student.getRollno());
        studentRespo.setSubject(student.getSubject());
        studentRespo.setIsCreatedAt(student.getIsCreatedAt());
        studentRespo.setIsUpdatedAt(student.getIsUpdatedAt());
        studentRespo.setMessage("Student created Successfully !");
        return studentRespo;
    }
    // for update
    private UpdateStudentResponseDto mapToUpdatedDto(Student student) {
        UpdateStudentResponseDto studentRespo=new UpdateStudentResponseDto();
        studentRespo.setId(student.getId());
        studentRespo.setName(student.getName());
        studentRespo.setEmail(student.getEmail());
        studentRespo.setAge(student.getAge());
        studentRespo.setRollno(student.getRollno());
        studentRespo.setSubject(student.getSubject());
        studentRespo.setIsUpdatedAt(student.getIsUpdatedAt());
        studentRespo.setMessage("Student updated Successfully !");
        return studentRespo;
    }
}
