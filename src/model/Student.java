package model;

public class Student {
    private int id;
    private String fullName;
    private double gpa;

    // Constructor
    public Student(int id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // ToString method for formatted output
    @Override
    public String toString() {
        return String.format("%-10d %-50s %.2f", id, fullName, gpa);
    }
}