import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH = "data/students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Student student : students) {

                writer.write(
                        student.getName() + "," +
                        student.getGrade());

                writer.newLine();
            }

            System.out.println("\nStudent data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving file: "
                    + e.getMessage());
        }
    }
}
