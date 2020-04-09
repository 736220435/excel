package com.springboot.servie.impl;

import com.springboot.entity.Student;
import com.springboot.servie.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> studentList() {
        return null;
    }

    @Override
    public Integer insertStudent(List<Student> students) {
        return null;
    }
}
