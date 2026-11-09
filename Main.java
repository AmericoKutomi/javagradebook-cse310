import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Main {

    /**
     * This program loads student data from a file, calculates their grades,
     * determines if they are approved or failed, calculates the class average,
     * and saves the results to a file.
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Student> students = new ArrayList<>();

        students = loadStudents();

        for (Student student : students) {

            System.out.print(
                    student.getName() + ": " +
                            student.getGrade() + " - ");

            if (student.isApproved()) {
                System.out.println("Approved");
            } else {
                System.out.println("Failed");
            }
        }

        double average = calculateAverage(students);
        System.out.println("Class average grade: " + average);

        saveResults(students);

    }

    /**
     * Loads student data from the "students.txt" file.
     *
     * @return An ArrayList of Student objects.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static ArrayList<Student> loadStudents() throws IOException {

        Path file = Path.of("students.txt");

        ArrayList<Student> students = new ArrayList<>();

        for (String line : Files.readAllLines(file)) {
            String[] parts = line.split(",");

            String name = parts[0];
            double grade = Double.parseDouble(parts[1]);

            students.add(new Student(name, grade));
        }

        return students;
    }

    /**
     * Calculates the average grade of the students.
     *
     * @param students An ArrayList of Student objects.
     * @return The average grade of the students.
     */
    public static double calculateAverage(ArrayList<Student> students) {

        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Student student : students) {
            total += student.getGrade();
        }

        return total / students.size();
    }

    /**
     * Saves the results of the students to the "results.txt" file.
     * 
     * @param students An ArrayList of Student objects.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveResults(ArrayList<Student> students) throws IOException {

        Path file = Path.of("results.txt");

        String content = "";

        for (Student student : students) {

            content += student.getName() + ": " +
                    student.getGrade() + " - ";

            if (student.isApproved()) {
                content += "Approved\n";
            } else {
                content += "Failed\n";
            }
        }

        double average = calculateAverage(students);

        content += "Class average: " + average + "\n";

        Files.writeString(file, content);
    }

}