
/**
 * 
 * @author (Tharaka Bandara)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Define a Student class to store student information
class Student {
    String lastName;
    String firstName;
    String studentID;
    double assignment1;
    double assignment2;
    double assignment3;
    double total;

    public Student(String lastName, String firstName, String studentID, double assignment1, double assignment2, double assignment3) {
        // Constructor to initialize student data
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.total = assignment1 + assignment2 + assignment3; // Calculate total marks

    }
    // Override the toString method to display student details
    @Override
    public String toString() {
        // Convert student details to a string format for printing
        return "Last Name: " + lastName + ", First Name: " + firstName + ", Student ID: " + studentID +
        ", Assignment 1: " + assignment1 + ", Assignment 2: " + assignment2 + ", Assignment 3: " + assignment3+
        ", Total Marks: " + total;
    }
}

public class AssignmentStatistics {

    public static void main(String[] args) {
        String unitName = "";
        List<Student> students = new ArrayList<>();
        String filePath = "E:\\student-grade.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line is empty or a comment line 
                if (line.trim().isEmpty() || line.trim().startsWith(" ")) {
                    continue;
                }

                // Check if the line contains the unit name
                if (line.startsWith("Unit Name:")) {
                    unitName = line.substring(11).trim();
                } else {
                    // Parse student data and create Student objects
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 5) {
                        String lastName = parts[0];
                        String firstName = parts[1];
                        String studentID = parts[2];
                        double assignment1 = Double.parseDouble(parts[3]);
                        double assignment2 = Double.parseDouble(parts[4]);
                        double assignment3 = Double.parseDouble(parts[5]);

                        // Create a Student object and add it to the list
                        Student student = new Student(lastName, firstName, studentID, assignment1, assignment2, assignment3);
                        students.add(student);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            // Display the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Print Unit Name and Student Details");
            System.out.println("2. Print Students Below Threshold");
            System.out.println("3. Print Top 5 Students (High and Low)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");

            // Get user's choice
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Print unit name and student details
                    printUnitNameAndStudentDetails(unitName, students);
                    break;
                case 2:
                    // Print students below the threshold
                    printStudentsBelowThreshold(students);
                    break;
                case 3:
                    // Print top 5 students
                    printTopStudents(students);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private static void printUnitNameAndStudentDetails(String unitName, List<Student> students) {
        // Print the unit name
        System.out.println("Unit Name: " + unitName);

        // Display student details
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }


    private static void printStudentsBelowThreshold(List<Student> students) {
        // Prompt the user for the threshold
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the threshold for total marks: ");
        double threshold = scanner.nextDouble();

        // Print students below the threshold
        System.out.println("\nStudents with total marks below the threshold:");
        for (Student student : students) {
            if (student.total < threshold) {
                System.out.println(student.toString());
            }
        }

    }

    private static void printTopStudents(List<Student> students) {
        // Sort students by total marks in descending order
        Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student student1, Student student2) {
                    return Double.compare(student2.total, student1.total);
                }
            });

        // Print the top 5 students with the highest total marks
        System.out.println("\nTop 5 Students with Highest Total Marks:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i).toString());
        }

        // Sort students by total marks in ascending order
        Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student student1, Student student2) {
                    return Double.compare(student1.total, student2.total);
                }
            });

        // Print the top 5 students with the lowest total marks
        System.out.println("\nTop 5 Students with Lowest Total Marks:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i).toString());
        }

    }
}
