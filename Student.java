public class Student {

    private String name;
    private double grade;

    /**
     * Constructs a new Student with the given name and grade.
     *
     * @param name  The name of the student.
     * @param grade The grade of the student.
     */
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * Checks if the student is approved based on their grade.
     *
     * @return true if the grade is 7.0 or higher, false otherwise.
     */
    public boolean isApproved() {
        return grade >= 7.0;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the grade of the student.
     *
     * @return The grade of the student.
     */
    public double getGrade() {
        return grade;
    }
}