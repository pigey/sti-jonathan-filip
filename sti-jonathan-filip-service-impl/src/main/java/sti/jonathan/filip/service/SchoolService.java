package sti.jonathan.filip.service;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;
import sti.jonathan.filip.domain.Vault;

public interface SchoolService {
    void setVault(Vault vault);

    Student getStudent(String personnummer);

    void addStudent(Student student);

    Course getCourse(String courseId);

    void addCourse(Course course);

    Teacher getTeacher(String personnummer);

    void addTeacher(Teacher teacher);

    void registerCourse(Student student, Course course);

    void removeCourse(Student student, Course course);
}
