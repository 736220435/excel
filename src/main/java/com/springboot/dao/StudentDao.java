package com.springboot.dao;

import com.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentDao {
    /**
     * 查询全部学生信息
     *
     * @return
     */
    public List<Student> studentList();

    /**
     * 批量插入学生信息
     *
     * @param students
     * @return
     */
    public Integer insertStudent(List<Student> students);
}
