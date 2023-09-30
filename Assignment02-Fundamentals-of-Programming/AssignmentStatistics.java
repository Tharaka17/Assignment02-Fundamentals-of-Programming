
/**
 * 
 * @author (Tharaka Bandara)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String filePath = "E:\student-grade.txt";

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

        // Display the unit name
        System.out.println("Unit Name: " + unitName);

        // Display student details
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
