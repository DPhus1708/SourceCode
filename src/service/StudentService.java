package service;

import model.Student;
import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) {
        for (Student st : students)
            if (st.getId() == s.getId()) return false;
        students.add(s);
        return true;
    }

    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students)
            if (s.getFullName().toLowerCase().contains(name.toLowerCase()))
                result.add(s);
        return result;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
