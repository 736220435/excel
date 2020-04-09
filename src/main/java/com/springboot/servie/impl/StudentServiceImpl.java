package com.springboot.servie.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;
import com.springboot.servie.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> studentList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentDao.studentList();
    }

    @Override
    public Integer insertStudent(List<Student> students) {
        return null;
    }
}
