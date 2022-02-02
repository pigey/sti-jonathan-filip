package sti.jonathan.filip.service.impl;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;
import sti.jonathan.filip.domain.Vault;

public class SchoolServiceImpl implements sti.jonathan.filip.service.SchoolService {
    private Vault vault;


    @Override
    public void setVault(Vault vault){
        this.vault = vault;

    }

    @Override
    public Student getStudent(String personnummer){
        return vault.getStudent(personnummer);
    }


    @Override
    public void addStudent(Student student) {
        vault.addStudent(student);
    }


    @Override
    public Course getCourse(String courseId){
        return vault.getCourse(courseId);
    }


    @Override
    public void addCourse(Course course){
        vault.addCourse(course);
    }


    @Override
    public Teacher getTeacher(String personnummer){
        return vault.getTeacher(personnummer);
    }

    @Override
    public void addTeacher(Teacher teacher){
        vault.addTeacher(teacher);
    }


    @Override
    public void registerCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);
    }
    @Override
    public void removeCourse(Student student, Course course){
        student.removeCourse(course);
        course.removeStudent(student);
    }
}
