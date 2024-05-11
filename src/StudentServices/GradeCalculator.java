package StudentServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GradeCalculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        C1_1();
    }
    public static void C1_1(){
        String columnWidth = "%-12.12s  %-5.5s %-15.15s %-15.15s%n";
        ArrayList<Student> n = new ArrayList<>();
        HashMap<Character, Number> gradeCountMap = new HashMap<>();

        System.out.println("Please enter the number of students in the course (between 1 and 6)");
        try{
            getStudentInput(n); // in place modification adds student info arrays [name, id, avgGrade, letterGrade]
            var highScore = n.get(0).getAvg();
            var highScoreName = n.get(0).getName();
            var lowScore = n.get(n.size()-1).getAvg();
            var lowScoreName = n.get(n.size()-1).getName();
            System.out.println();
            System.out.printf(columnWidth, "Name", "ID", "Average Grade", "Letter Achieved");
            int aCount = 0, bCount = 0, cCount = 0, dCount = 0, fCount = 0;// This is stupid
            for (Student student : n) {
                String name = student.getName();
                int id = student.getId();
                double avg = student.getAvg();
                char letterGrade = student.getLetterGrade();
                switch (letterGrade) {
                    case 'A':
                        ++aCount;
                        gradeCountMap.put(letterGrade, aCount);
                        break;
                    case 'B':
                        ++bCount;
                        gradeCountMap.put(letterGrade, bCount);
                        break;
                    case 'C':
                        ++cCount;
                        gradeCountMap.put(letterGrade, cCount);
                        break;
                    case 'D':
                        ++dCount;
                        gradeCountMap.put(letterGrade, dCount);
                        break;
                    case 'F':
                        ++fCount;
                        gradeCountMap.put(letterGrade, fCount);
                        break;
                    default:
                        throw new Exception("Invalid letter grade"); // Should be unreachable but will let me know if I made an eggregious error.
                }
                System.out.printf(columnWidth, name, id, String.format("%.2f", avg), letterGrade);
            }
            System.out.println("\nClass Statistics:");
            System.out.println("Highest Average Grade: " + String.format("%.2f", highScore) + " (StudentServices.Student: " + highScoreName + ")" );
            System.out.println("Lowest Average Grade: "+ String.format("%.2f", lowScore) + " (StudentServices.Student: " + lowScoreName + ")" );
            System.out.println();

            System.out.println("Grade Distribution: \n");
            var keys = gradeCountMap.keySet().toArray();
            var values = gradeCountMap.values().toArray();
            for (int i = 0; i < gradeCountMap.size(); i++) {
                System.out.println(keys[i] + String.format(": %d student(s)", (int) values[i]));
            }
        }catch (NumberFormatException e){
            System.out.println("Input was not a number, try again.");
            C1_1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            C1_1();
        }
    }
    public static void getAvgScore(String studentInfo, Student student) throws Exception{
        var grades = studentInfo.split(" ");
        int sum = 0;
        for (int k = 0; k < grades.length; k++) {
            var grade = Integer.parseInt(grades[k]); // throws numberformatexception
            if (grade < 1 || grade > 100) { // This would be better if it didn't make the user start all the way over, but it works.
                throw new Exception("Grade " + (k+1) + " was " + grade + "\nAll three entries for grade must be between 1 and 100. Try again");
            }
            sum += grade;
        }
        float avg = (float) sum / grades.length;
        char letterGrade;
        if(avg >= 90){ // This would be improved by casting avg to an enum and using a switch I think, but this works.
            letterGrade = 'A';
        } else if (avg >= 80) {
            letterGrade = 'B';
        } else if (avg >= 70) {
            letterGrade = 'C';
        } else if (avg >= 60) {
            letterGrade = 'D';
        } else{
            letterGrade = 'F';
        }
        student.setAvg(avg);
        student.setLetterGrade(letterGrade);
    }
    public static void getStudentInput(ArrayList<Student> n) throws Exception{
        int students = Integer.parseInt(scanner.nextLine());
        if (students < 1 || students > 6 ){
            throw new Exception("Input not between 1 and 6 Try again.");
        }
        for (int i = 0; i < students; i++) {
            Student student = new Student();
            for (int j = 0; j < 3; j++) { // adds 3 items, name, id, (score1,score2,score3)/3, lettergrade
                var studentInfo = scanner.nextLine().trim();
                switch (j){
                    case 0:
                        System.out.println("\nEnter student name: ");
                        student.setName(studentInfo);
                        break;
                    case 1:
                        System.out.println("Enter student ID: ");
                        student.setId(scanner.nextInt());
                        break;
                    case 2:
                        System.out.println("Enter student grades (three scores separated by spaces): ");
                        getAvgScore(studentInfo, student);
                        break;
                }
            }
            System.out.println("\nStudentServices.Student Information: ");
            System.out.println("\tName: "+ student.getName());
            System.out.println("\tID: "+ student.getId());
            System.out.printf("\tAverage Score: %.2f \n", student.getAvg());
            System.out.println("\tLetter Achieved: "+ student.getLetterGrade());
            n.add(student);
        }
        // sort
        for (int i = n.size()-1; i >= 0; i--) {
            var outerStudent = n.get(i);
            for (int j = 0; j < i; j++) {
                var innerStudent = n.get(j);
                if( innerStudent.getAvg() < outerStudent.getAvg()){
                    var temp = outerStudent;
                    n.set(i, innerStudent);
                    n.set(j, temp);
                    outerStudent = n.get(i);
                }
            }
        }
    }
}
