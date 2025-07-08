import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

// BuiDacPhu - SE196499
public class Main {

    private static final StudentService service = new StudentService();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    exitProgram();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search student");
        System.out.println("4. Display all students");
        System.out.println("5. Exit");
        System.out.print("Select: ");
    }

    private static int getUserChoice() {
        return sc.nextInt();
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter full name (max 50 characters): ");
        String name = sc.nextLine();

        System.out.print("Enter GPA (0.0 - 4.0): ");
        double gpa = sc.nextDouble(); sc.nextLine();

        try {
            Student student = new Student(id, name, gpa);
            if (service.addStudent(student)) {
                System.out.println("Student added successfully.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int deleteId = sc.nextInt(); sc.nextLine();
        boolean removed = service.removeStudent(deleteId);
        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        List<Student> foundStudents = service.searchByName(searchName);
        if (foundStudents.isEmpty()) {
            System.out.println("No students found with the name '" + searchName + "'.");
        } else {
            System.out.println("Search results:");
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        }
    }

    private static void displayAllStudents() {
        List<Student> allStudents = service.getAllStudents();
        if (allStudents.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("All students:");
            for (Student student : allStudents) {
                System.out.println(student);
            }
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
    }
}
