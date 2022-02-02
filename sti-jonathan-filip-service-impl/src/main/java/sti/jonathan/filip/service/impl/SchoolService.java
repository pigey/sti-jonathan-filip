package sti.jonathan.filip.service.impl;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;
import sti.jonathan.filip.domain.Vault;

public class SchoolService  {
    private Vault vault;


    public void setVault(Vault vault){
        this.vault = vault;

    }

    public Student getStudent(String personnummer){
        return vault.getStudent(personnummer);
    }


    public void addStudent(Student student) {
        vault.addStudent(student);
    }


    public Course getCourse(String courseId){
        return vault.getCourse(courseId);
    }


    public void addCourse(Course course){
        vault.addCourse(course);
    }


    public Teacher getTeacher(String personnummer){
        return vault.getTeacher(personnummer);
    }

    public void addTeacher(Teacher teacher){
        vault.addTeacher(teacher);
    }


    public void registerCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);
    }
    public void removeCourse(Student student, Course course){
        student.removeCourse(course);
        course.removeStudent(student);
    }
}
