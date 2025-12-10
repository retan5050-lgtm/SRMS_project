import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        StudentManager manager = new StudentManager();

        FileHandler.loadFromFile(manager.getStudents(), "students.txt");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Generate Report");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    double gpa = 0;
                    boolean validGpa = false;
                    while (!validGpa) {
                        try {
                            System.out.print("Enter student GPA: ");
                            gpa = scanner.nextDouble();
                            validGpa = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for GPA. Please enter a valid number.");
                            scanner.nextLine(); 
                        }
                    }

                    scanner.nextLine(); 
                    System.out.print("Enter student department: ");
                    String department = scanner.nextLine();

                    manager.addStudent(new Student(id, name, gpa, department));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                   
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new student name: ");
                    String updateName = scanner.nextLine();
                    double updateGpa = 0;
                    boolean validUpdateGpa = false;
                    while (!validUpdateGpa) {
                        try {
                            System.out.print("Enter new student GPA: ");
                            updateGpa = scanner.nextDouble();
                            validUpdateGpa = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for GPA. Please enter a valid number.");
                            scanner.nextLine(); 
                        }
                    }

                    scanner.nextLine();
                    System.out.print("Enter new student department: ");
                    String updateDepartment = scanner.nextLine();

                    manager.updateStudent(updateId, updateName, updateGpa, updateDepartment);
                    System.out.println("Student updated successfully!");
                    break;

                case 3:
            
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeStudent(removeId);
                    System.out.println("Student removed successfully!");
                    break;

                case 4:
                  
                    manager.generateReport();
                    break;

                case 5:
                  
                    FileHandler.saveToFile(manager.getStudents(), "students.txt");
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
