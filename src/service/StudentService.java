package service;

import model.Student;
import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    // Method to add a student
    public boolean addStudent(Student s) throws Exception {
        for (Student student : students) {
            if (student.getId() == s.getId()) {
                throw new Exception("Student ID already exists!");
            }
        }

        if (s.getGpa() < 0 || s.getGpa() > 4) {
            throw new Exception("Invalid GPA! GPA must be between 0.0 and 4.0.");
        }

        students.add(s);
        return true;
    }

    // Method to remove a student by ID
    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    // Method to search for a student by name (case-insensitive)
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Method to get all students
    public List<Student> getAllStudents() {
        return students;
    }
}