package sti.jonathan.filip.domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int yhPoints;
    private Teacher teacher;
    private String courseId;
    private double courseHours;
    private List<Student> students = new ArrayList<>();

    public Course(int yhPoints, Teacher teacher, String courseId, double courseHours){
        this.yhPoints = yhPoints;
        this.teacher = teacher;
        this.courseId = courseId;
        this.courseHours = courseHours;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getYhPoints() {
        return yhPoints;
    }

    public void setYhPoints(int yhPoints) {
        this.yhPoints = yhPoints;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(double courseHours) {
        this.courseHours = courseHours;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String toString(){
        StringBuffer buf = new StringBuffer();

        buf.append(courseId);
        for (Student s:students) {
            buf.append("\n").append(s.getfName()).append(" ").append(s.geteName());
        }
        return buf.toString();
    }
}
