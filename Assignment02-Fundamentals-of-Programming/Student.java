
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
}