package service;

import model.Student;
import java.util.*;

public class StudentService {
    private int id;
    private String fullName;
    private double gpa;
    private List<Student> students = new ArrayList<>();
    public StudentService() {
       
    }
    public StudentService(int id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }
    public boolean addStudent(Student s) {
        for (Student st : students)
            if (st.getId() == s.getId()) return false;
        students.add(s);
        return true;
    }


    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public double getGpa() { return gpa; }
    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students)
            if (s.getFullName().toLowerCase().contains(name.toLowerCase()))
                result.add(s);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %.2f", id, fullName, gpa);
    }
    public List<Student> getAllStudents() {
        return students;
    }
}
 


