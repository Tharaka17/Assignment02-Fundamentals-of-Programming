
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

    public Student(String lastName, String firstName, String studentID, double assignment1, double assignment2, double assignment3) {
        // Constructor to initialize student data
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
    }
    // Override the toString method to display student details
    @Override
    public String toString() {
        return "Last Name: " + lastName + ", First Name: " + firstName + ", Student ID: " + studentID +
        ", Assignment 1: " + assignment1 + ", Assignment 2: " + assignment2 + ", Assignment 3: " + assignment3;
    }
}

public class AssignmentStatistics {

    public static void main(String[] args) {
        String unitName = "";
        List<Student> students = new ArrayList<>();
        String filePath = "F:\WALLPAPER\Assignment02\Assignment02-Fundamentals-of-Programming\Assignment02-Fundamentals-of-Programming\student-grade.txt";
    }
}