package com.reborntech.springredis.repositories;

import com.reborntech.springredis.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class StudentRepository {
    public static final String HASH_KEY = "Student";
    @Autowired
    private RedisTemplate template;

    public Student save(Student student){
        template.opsForHash().put(HASH_KEY, student.getRegistrationNo(),student);
        return student;
    }

    public List<Student> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Student findByRegistrationNo(String regisNo){
        return (Student) template.opsForHash().get(HASH_KEY,regisNo);
    }

    public void deleteStudent(String regisNo){
        template.opsForHash().delete(HASH_KEY, regisNo);
    }
}
