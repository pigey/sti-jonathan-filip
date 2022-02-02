package sti.jonathan.filip;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;
import sti.jonathan.filip.domain.Vault;
import sti.jonathan.filip.service.impl.SchoolService;

import java.util.Scanner;

public class App {
    private Vault vault = new Vault();
    private SchoolService schoolService;
    public static void main(String[] args) {
        App app = new App();
        app.setupServices();
        app.setupData();
        app.addCoursesToStudents();
        app.getUserInput();
    }

    private void getUserInput() {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("Menu \n 1.Add Student \n 2.Register Course \n 3.Remove Course \n 4.Get Student \n 5.Exit");
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    removeCourse();
                    break;
                case 4:
                    getStudent();
                    break;
                case 5:
                    System.out.println("bye");
                    loop = false;

            }
        }
    }

    private void getStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv Students personnummer");
        String person = scan.nextLine();
        Student student = schoolService.getStudent(person);
        if (student == null){
            System.out.println("finns ingen med detta personnummer \n");
        }
        else
        System.out.println(student);
    }

    private void removeCourse() {
    }

    private void registerCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken student ska du registrera en kurs till?\n skriv personnummer");
        String person =scan.nextLine();
        Student student = schoolService.getStudent(person);
        System.out.println("vilken kurs vill du registrera?\n 1.html \n 2.css \n 3.java");
        int userChoice = scan.nextInt();
        switch (userChoice){
            case 1:
                schoolService.registerCourse(student,schoolService.getCourse("html"));
                break;
            case 2:
                schoolService.registerCourse(student,schoolService.getCourse("css"));
                break;
            case 3:
                schoolService.registerCourse(student,schoolService.getCourse("java"));
        }
    }

    private void registerStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("First name: ");
        String fName = scan.nextLine();
        System.out.println("Last name: ");
        String eName = scan.nextLine();
        System.out.println("Personnummer: ");
        String personnummer = scan.nextLine();

        Student student = new Student(fName, eName, personnummer);
        schoolService.addStudent(student);
    }

    private void setupServices() {
        schoolService = new SchoolService(vault);
    }

    private void addCoursesToStudents() {
        Student filip = schoolService.getStudent("0002251111");

        schoolService.registerCourse(filip,schoolService.getCourse("java"));
        schoolService.registerCourse(filip,schoolService.getCourse("html"));
        schoolService.registerCourse(filip,schoolService.getCourse("css"));


        Student john = schoolService.getStudent("0012315555");

        schoolService.registerCourse(john,schoolService.getCourse("java"));
        schoolService.registerCourse(john,schoolService.getCourse("html"));

    }

    public void setupData(){


        Teacher teacher1 = new Teacher("Bert","Gustavsson","9503531111",300);
        schoolService.addTeacher(teacher1);

        Course java = new Course(20,teacher1,"java",25);
        Course html = new Course(20,teacher1,"html",25);
        Course css = new Course(20,teacher1,"css",25);

        schoolService.addCourse(java);
        schoolService.addCourse(html);
        schoolService.addCourse(css);

        Student filip = new Student("filip","mathsson","0002251111");

        schoolService.addStudent(filip);




        Student john = new Student("john","johnsson","0012315555");

        schoolService.addStudent(john);


    }
}
