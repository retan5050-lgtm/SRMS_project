import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Update a student's record
    public void updateStudent(int id, String name, double gpa, String department) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                students.add(new Student(id, name, gpa, department));
                break;
            }
        }
    }

    // Remove a student
    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    // Generate report
    public void generateReport() {
        System.out.println("ID, Name, GPA, Department");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Get all students
    public List<Student> getStudents() {
        return students;
    }
}
