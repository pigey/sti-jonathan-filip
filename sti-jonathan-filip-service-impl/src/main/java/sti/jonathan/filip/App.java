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
    Course course;
    Teacher teacher;
    public static void main(String[] args) {
        App app = new App();
        SchoolService setup = new SchoolService(app.vault);
        setup.setUp();
        app.setupServices();
        //app.setupData();
        //app.addCoursesToStudents();
        app.getUserInput();

    }

    private void getUserInput() {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("Menu \n 1.Add Student \n 2.Register Course \n 3.Remove Course \n 4.Get Student \n 5.Exit");
            int userChoice = scan.nextInt();
            //todo lägg till trycatch
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
        //todo detta
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken elev vill du ta bort en kurs ifran? Skriv personnummer");
        String person = scan.nextLine();
        Student student = schoolService.getStudent(person);
        System.out.println("vilken kurs vill du ta bort? \n 1.java \n 2.html \n 3.css");
        int course = scan.nextInt();
        switch(course){
            case 1:
                schoolService.removeCourse(student,schoolService.getCourse("java"));
                break;
            case 2:
                schoolService.removeCourse(student,schoolService.getCourse("html"));
                break;
            case 3:
                schoolService.removeCourse(student,schoolService.getCourse("css"));
                break;
        }
    }

    private void registerCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken student ska du registrera en kurs till?\n skriv personnummer");
        String person =scan.nextLine();
        // todo kolla så att den inte blir null innan vi försöker lägga till kurser
        Student student = schoolService.getStudent(person);
        System.out.println("vilken kurs vill du registrera?\n 1.html \n 2.css \n 3.java");
        int userChoice = scan.nextInt();
        //todo add try catch ifall man skriver in bokstäver
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

}
