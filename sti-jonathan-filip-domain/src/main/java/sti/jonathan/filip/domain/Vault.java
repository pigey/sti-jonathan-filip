package sti.jonathan.filip.domain;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Vault {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(String courseId){
        for (Course c:courses) {
            if (c.getCourseId().equals(courseId)){
                return c;
            }

        }
        return null;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
    public void removeCourse(Course course){courses.remove(course);}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(String personnummer){
        for (Student s:students) {
            if (s.getPersonNummer().equals(personnummer)){
                return s;
            }

        }
        return null;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public Teacher getTeacher(String personnummer){
        for (Teacher t:teachers) {
            if (t.getPersonNummer().equals(personnummer)){
                return t;
            }

        }
        return null;
    }
}
