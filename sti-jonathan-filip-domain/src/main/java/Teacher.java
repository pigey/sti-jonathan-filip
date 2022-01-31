import java.util.ArrayList;

public class Teacher {
    private String fName;
    private String eName;
    private String personNummer;
    private ArrayList<Course> courseList = new ArrayList<>();
    private double hourSalary;

    public Teacher(String fName, String eName, String personNummer, ArrayList<Course> courseList, double hourSalary){
        this.fName = fName;
        this.eName = eName;
        this.personNummer = personNummer;
        this.courseList = courseList;
        this.hourSalary = hourSalary;
    }
}
