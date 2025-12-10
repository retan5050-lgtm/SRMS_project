public class Student extends Person {
    private double gpa;
    private String department;

    // Constructor
    public Student(int id, String name, double gpa, String department) {
        super(id, name); 
        this.gpa = gpa;
        this.department = department;
    }

    // Getters
    public double getGpa() {
        return gpa;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        
        return super.toString() + "," + gpa + "," + department;
    }
}
