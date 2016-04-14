package com.mybatis.gradle.testclasses;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.gradle.models.Student;
import com.mybatis.gradle.services.StudentService;


public class StudentServiceTest {
    private static StudentService studentService;

    @BeforeClass
    public static void setup() {
        studentService = new StudentService();
        TestDataPopulator.initDatabase(true);
    }

    @AfterClass
    public static void teardown() {
        studentService = null;
    }

    // find all students
    @Test
    public void testFindAllStudents() {
        List<Student> students = studentService.findAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // search a student with student id
    @Test
    public void testfindStudentById() {
        Student student = studentService.findStudentById(1);
        System.out.println(student);
    }

    // Create a student
    @Test
    public void testInsertStudents() {
        studentService.createStudent(new Student(3, "Solo", "solo@gmail.com", new Date()));
    }

    // Update student details
    @Test
    public void testUpdateStudent() {
        Student student = studentService.findStudentById(1);

        student.setName("Golya" + student.getName());
        student.setEmail("zsolt.golya@tcs.com");

        studentService.updateStudent(student);
        student = studentService.findStudentById(1);
        System.out.println(student);
    }
}
