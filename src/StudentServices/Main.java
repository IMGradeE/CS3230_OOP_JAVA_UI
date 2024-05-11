package StudentServices;

public class Main {
    public static void main(String[] args) {
        // Create a StudentServices.StudentDatabase
        StudentDatabase database = new StudentDatabase();

        // Add students to the database
        int[] grades1 = {90, 85, 92, 78, 88};
        int[] grades2 = {85, 80, 75, 92, 89};
        int[] grades3 = {92, 88, 91, 86, 90};

        Student student1 = new Student(1, "John", "Doe", grades1);
        Student student2 = new Student(2, "Jane", "Smith", grades2);
        Student student3 = new Student(3, "Tom", "Johnson", grades3);

        database.addStudent(student1);
        database.addStudent(student2);
        database.addStudent(student3);

        // Print all students
        System.out.println("All Students:");
        database.printAllStudents();

        // Remove a student
        database.removeStudent(2);

        // Print all students again
        System.out.println("\nStudents after removing student with ID 2:");
        database.printAllStudents();

        // Calculate and print the average grade of student 1
        double averageGrade = student1.getAvg();
        System.out.println("\nAverage Grade of StudentServices.Student 1: " + averageGrade);
    }

}

