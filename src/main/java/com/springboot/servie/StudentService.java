package com.springboot.servie;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Student;

import java.util.List;

public interface StudentService {
    public PageInfo<List<Student>> studentList(Integer pageNum, Integer pageSize);

    public Integer insertStudent(List<Student> students);
}
