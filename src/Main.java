import model.Student;
import service.StudentService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

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

                    System.out.print("Enter full name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble(); sc.nextLine();

                    if (gpa < 0 || gpa > 4) {
                        System.out.println("Invalid GPA!");
                        break;
                    }

                    boolean added = service.addStudent(new Student(id, name, gpa));
                    if (added) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student ID already exists!");
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
            }
        }
    }
}
