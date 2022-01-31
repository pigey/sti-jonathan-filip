import java.util.ArrayList;

public class Student {
    private String fName;
    private String eName;
    private String personNummer;
    private ArrayList<Course> courseList = new ArrayList<>();

    public Student(String fName, String eName, String personNummer, ArrayList<Course> courseList){
        this.fName = fName;
        this.eName = eName;
        this.personNummer = personNummer;
        this.courseList = courseList;
    }


}
