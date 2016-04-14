package com.mybatis.gradle.mappers;

import com.mybatis.gradle.models.Student;

import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AssetMapper {

    @Select("select * from Students")
    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);

    void updateStudent(Student student);

}
