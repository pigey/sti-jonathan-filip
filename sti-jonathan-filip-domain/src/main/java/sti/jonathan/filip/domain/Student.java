package sti.jonathan.filip.domain;

import sti.jonathan.filip.domain.Course;

import java.util.ArrayList;

public class Student {
    private String fName;
    private String eName;
    private String personNummer;
    private ArrayList<Course> courseList = new ArrayList<>();



    public Student(String fName, String eName, String personNummer) {
        this.fName = fName;
        this.eName = eName;
        this.personNummer = personNummer;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public void setPersonNummer(String personNummer) {
        this.personNummer = personNummer;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }
    public void removeCourse(Course course){
        courseList.remove(course);
    }

    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append(fName).append(" ").append(eName).append(" ").append(personNummer).append(" Courses:");
        for (Course c:courseList) {
            buf.append("\n").append(c.getCourseId());
        }
        buf.append("\n");
        return buf.toString();
    }
}

