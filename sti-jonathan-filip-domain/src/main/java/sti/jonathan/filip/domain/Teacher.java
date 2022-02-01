package sti.jonathan.filip.domain;

import sti.jonathan.filip.domain.Course;

import java.util.ArrayList;

public class Teacher {
    private String fName;
    private String eName;
    private String personNummer;
    private ArrayList<Course> courseList = new ArrayList<>();
    private double hourSalary;

    public Teacher(String fName, String eName, String personNummer, double hourSalary){
        this.fName = fName;
        this.eName = eName;
        this.personNummer = personNummer;
        this.hourSalary = hourSalary;
    }

    public String getPersonNummer() {
        return personNummer;
    }
}
