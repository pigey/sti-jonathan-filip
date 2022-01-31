import java.util.ArrayList;

public class Teacher {
    private String fName;
    private String eName;
    private int personNummer;
    private ArrayList<Course> courseList = new ArrayList<>();
    private int hourSalary;

    public Teacher(String fName, String eName, int personNummer, ArrayList<Course> courseList, int hourSalary){
        this.fName = fName;
        this.eName = eName;
        this.personNummer = personNummer;
        this.courseList = courseList;
        this.hourSalary = hourSalary;
    }
}
