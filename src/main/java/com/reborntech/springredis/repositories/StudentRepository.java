package com.reborntech.springredis.repositories;

import com.reborntech.springredis.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class StudentRepository {
    public static final String HASH_KEY = "Student";
    @Autowired
    private RedisTemplate template;

    Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public Student save(Student student){
        template.opsForHash().put(HASH_KEY, student.getRegistrationNo(),student);
        logger.info("Student record created successfully!");
        return student;
    }

    public List<Student> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Student findByRegistrationNo(String regisNo){
        return (Student) template.opsForHash().get(HASH_KEY,regisNo);
    }

    public Student updateStudent(Student student){
        template.opsForHash().put(HASH_KEY, student.getRegistrationNo(), student);
        logger.info("Student record updated successfully!");
        return student;
    }

    public void deleteStudent(String regisNo){
        template.opsForHash().delete(HASH_KEY, regisNo);
        logger.info("Student record deleted successfully!");
    }
}
