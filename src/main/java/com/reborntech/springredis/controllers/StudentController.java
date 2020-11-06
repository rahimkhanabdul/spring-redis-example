package com.reborntech.springredis.controllers;

import com.reborntech.springredis.entities.Student;
import com.reborntech.springredis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{regisNo}")
    public Student getStudentByRegistrationNo(@PathVariable String regisNo){
        return studentRepository.findByRegistrationNo(regisNo);
    }

    @DeleteMapping("/{regisNo}")
    public void removeStudent(@PathVariable String regisNo){
        studentRepository.deleteStudent(regisNo);
    }
}
