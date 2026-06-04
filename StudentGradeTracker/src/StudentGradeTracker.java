import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name, grade));
        }

        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();

        String highestStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        for (Student s : students) {

            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
                highestStudent = s.getName();
            }

            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
                lowestStudent = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n========== SUMMARY REPORT ==========");

        for (Student s : students) {
            System.out.println(
                    "Name: " + s.getName() +
                    " | Grade: " + s.getGrade());
        }

        System.out.println("\nAverage Score : " + average);
        System.out.println("Highest Score : " + highest +
                " (" + highestStudent + ")");
        System.out.println("Lowest Score  : " + lowest +
                " (" + lowestStudent + ")");

        FileManager.saveStudents(students);

        sc.close();
    }
}