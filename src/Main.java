import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Add student");
                System.out.println("2. Delete student");
                System.out.println("3. Search student");
                System.out.println("4. Display all students");
                System.out.println("5. Exit");
                System.out.print("Select: ");
                int choice = sc.nextInt(); sc.nextLine();
                switch (choice) {
                    case 1:
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
                    break;
                    
                    case 2:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt(); sc.nextLine();
                        boolean removed = service.removeStudent(deleteId);
                        if (removed) {
                            System.out.println("Student deleted.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                     case 3:
                        // Search student by name
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
                        break;

                    case 4:
                        // Display all students
                        List<Student> allStudents = service.getAllStudents();
                        if (allStudents.isEmpty()) {
                            System.out.println("No students available.");
                        } else {
                            System.out.println("All students:");
                            for (Student student : allStudents) {
                                System.out.println(student);
                            }
                        }
                        break;

                    case 5:
                        // Exit program
                        System.out.println("Exiting...");
                        return;  // Exit the program

                    default:
                        System.out.println("Invalid choice! Please choose a valid option.");


                }
            }
        }
    }
}