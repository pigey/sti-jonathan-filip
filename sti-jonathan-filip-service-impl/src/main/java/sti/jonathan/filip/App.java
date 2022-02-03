package sti.jonathan.filip;

import sti.jonathan.filip.domain.Course;
import sti.jonathan.filip.domain.Student;
import sti.jonathan.filip.domain.Teacher;
import sti.jonathan.filip.domain.Vault;
import sti.jonathan.filip.service.SchoolService;
import sti.jonathan.filip.service.impl.SchoolServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class App {
    private Vault vault;
    private SchoolService schoolService;
    Course course;
    Teacher teacher;
    //this main will not be used in springboot
    public static void main(String[] args) {
        Vault v = new Vault();
        v.setUp();
        App app = new App();
        app.setVault(v);
        app.setupServices();
        //app.setupData();
        //app.addCoursesToStudents();
        app.getUserInput();

    }

    private void setVault(Vault vault) {
        this.vault = vault;
    }

    public App(){

    }

    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private void getUserInput() {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("Menu \n 1.Add Student \n 2.Register Course \n 3.Remove Course \n 4.Get Student \n 5.Exit");
            try {
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
                        break;
                    default:
                        System.out.println("skriv en siffra mellan 1-5!");

                }
            }catch (InputMismatchException e){
                scan.next();
                System.out.println("Skriv en siffra tack!");
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken elev vill du ta bort en kurs ifran? Skriv personnummer");
        String person = scan.nextLine();
        Student student = schoolService.getStudent(person);
        if (student == null){
            System.out.println("Finns ingen person med detta personnummer");
        }
        else {


            boolean catcher = true;
            System.out.println("vilken kurs vill du ta bort? \n 1.java \n 2.html \n 3.css");
            while (catcher) {
                try {
                    int course = scan.nextInt();
                    switch (course) {
                        case 1:
                            schoolService.removeCourse(student, schoolService.getCourse("java"));
                            catcher = false;
                            break;
                        case 2:
                            schoolService.removeCourse(student, schoolService.getCourse("html"));
                            catcher = false;
                            break;
                        case 3:
                            schoolService.removeCourse(student, schoolService.getCourse("css"));
                            catcher = false;
                            break;
                        default:
                            System.out.println("ska vara en siffra mellan 1-3!");
                    }
                } catch (InputMismatchException e) {
                    scan.next();
                    System.out.println("skriv en siffra mellan 1-3!");
                }
            }
        }
    }

    private void registerCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken student ska du registrera en kurs till?\n skriv personnummer");
        String person =scan.nextLine();
        Student student = schoolService.getStudent(person);
        if (student == null){
            System.out.println("Finns ingen person med detta personnummer");
        }
        else {

            System.out.println("vilken kurs vill du registrera?\n 1.html \n 2.css \n 3.java");

            boolean catcher = true;
            while (catcher) {
                try {
                    int userChoice = scan.nextInt();
                    switch (userChoice) {
                        case 1:
                            schoolService.registerCourse(student, schoolService.getCourse("html"));
                            catcher = false;
                            break;
                        case 2:
                            schoolService.registerCourse(student, schoolService.getCourse("css"));
                            catcher = false;
                            break;
                        case 3:
                            schoolService.registerCourse(student, schoolService.getCourse("java"));
                            catcher = false;
                        default:
                            System.out.println("ska vara en siffra mellan 1-3!");
                    }
                } catch (InputMismatchException e) {
                    scan.next();
                    System.out.println("skriv en siffra mellan 1-3!");
                }
            }
        }


    }
//todo se till satt personnummer bara är siffror och är 10 char long
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

    //todo lägga till lärarens månads lön samt medellön för lärare

    private void setupServices() {
        schoolService = new SchoolServiceImpl();
        schoolService.setVault(vault);
    }

}
