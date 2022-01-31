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
}
