package com.mybatis.gradle.services;

import com.mybatis.gradle.mappers.AssetMapper;
import com.mybatis.gradle.models.Student;
import com.mybatis.gradle.util.MyBatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class StudentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Student> findAllStudents() {
        AssetMapper studentMapper;
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            studentMapper = sqlSession.getMapper(AssetMapper.class);
            return studentMapper.findAllStudents();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public Student findStudentById(Integer studId) {
        logger.debug("Select Student By ID {}", studId);
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper studentMapper = sqlSession.getMapper(AssetMapper.class);
            return studentMapper.findStudentById(studId);
        }
    }

    public void createStudent(Student student) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper studentMapper = sqlSession.getMapper(AssetMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        }
    }

    public void updateStudent(Student student) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession()) {
            AssetMapper studentMapper = sqlSession.getMapper(AssetMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
        }
    }
}
