package com.reborntech.springredis.controllers;

import com.reborntech.springredis.entities.Student;
import com.reborntech.springredis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    Logger logger = Logger.getLogger(StudentController.class.getName());

    @PostMapping
    public Student save(@RequestBody Student student){
        logger.info("Creating a student record!");
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        logger.info("Fetching all student records!");
        return studentRepository.findAll();
    }

    @GetMapping("/{regisNo}")
    public Student getStudentByRegistrationNo(@PathVariable String regisNo){
        logger.info("fetching a student record by registration No.!");
        return studentRepository.findByRegistrationNo(regisNo);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        logger.info("Updating a student record!");
        studentRepository.updateStudent(student);
    }

    @DeleteMapping("/{regisNo}")
    public void removeStudent(@PathVariable String regisNo){
        logger.info("Deleting a student record!");
        studentRepository.deleteStudent(regisNo);
    }
}
