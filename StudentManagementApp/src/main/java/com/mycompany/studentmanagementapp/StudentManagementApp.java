/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Example Student class - Java Code Examples 

//Java Class Methods (w3schools.com) 

//Default Constructor in Java – Class Constructor Example (freecodecamp.org) 

//Java console application - creating a console application in Java (zetcode.com) 
package com.mycompany.studentmanagementapp;

/**
 *
 * @author brook
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nCourse: " + course;
    }
}

public class StudentManagementApp {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("******************************");
            System.out.println("Please select one of the following menu items:");
            System.out.println("1. Capture a new student.");
            System.out.println("2. Search for a student.");
            System.out.println("3. Delete a student.");
            System.out.println("4. Print student report.");
            System.out.println("5. Exit Application.");
            
            selection = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (selection) {
                case 1:
                    captureStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    // Code to delete a student
                    System.out.println("You selected: Delete a student.");
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting Application.");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (selection != 5);
        
        scanner.close();
    }

    private static void captureStudent(Scanner scanner) {
        System.out.println("Enter the student id:");
        String id = scanner.nextLine();
        System.out.println("Enter the student name:");
        String name = scanner.nextLine();
        
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            try {
                System.out.println("Enter the student age:");
                age = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (age >= 16) {
                    validAge = true;
                } else {
                    System.out.println("Invalid age. Please enter an age greater than or equal to 16.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();  // Clear the invalid input
            }
        }

        System.out.println("Enter the student email:");
        String email = scanner.nextLine();
        System.out.println("Enter the student course:");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        students.add(student);
        System.out.println("Student captured successfully!");
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("Enter the student ID to search:");
        String id = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " cannot be located.");
        }
    }

    private static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
                System.out.println("-------------------------");
            }
        }
    }
}

