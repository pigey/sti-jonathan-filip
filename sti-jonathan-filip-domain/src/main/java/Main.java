import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courseList = null;
        ArrayList<Course> courseListFilip = new ArrayList<>();
        ArrayList<Course> courseListJohn = new ArrayList<>();

        Teacher teacher1 = new Teacher("Bert","Gustavsson","9503531111",courseList,300);
        Course java = new Course(20,teacher1,"java",25);
        Course html = new Course(20,teacher1,"html",25);
        Course css = new Course(20,teacher1,"css",25);

        Student filip = new Student("filip","mathsson","0002251111",courseListFilip);

       filip.addCourse(java);
       filip.addCourse(html);
       filip.addCourse(css);

       Student john = new Student("john","johnsson","0012315555",courseListJohn);

       john.addCourse(java);
       john.addCourse(css);


        System.out.println(filip.getfName()+" "+ filip.geteName()+" "+filip.getPersonNummer());
        for (int i = 0; i < courseListFilip.size(); i++) {
            System.out.println(filip.getCourseList().get(i).getCourseId());
        }

        System.out.println(john.getfName()+" "+john.geteName()+" "+john.getPersonNummer());
        for (int i = 0; i < courseListJohn.size(); i++) {
            System.out.println(john.getCourseList().get(i).getCourseId());

        }



    }
}
