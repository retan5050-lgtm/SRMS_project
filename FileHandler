import java.io.*;
import java.util.List;

public class FileHandler {

    // Save student data to file
    public static void saveToFile(List<Student> students, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load student data from file
    public static void loadFromFile(List<Student> students, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
