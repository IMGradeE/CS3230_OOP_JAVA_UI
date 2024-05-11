package StudentServices;

import java.util.ArrayList;

public final class Student {
    // Returns an empty instance of the StudentServices.Student class since this class is used elsewhere in the repository
    public Student(){}

    // returns a fully initialized StudentServices.Student object
    public Student(int id, String firstName, String lastName, int[] grades) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setName(firstName+" "+lastName);
        setGrades(grades);
        updateAvg();
    }

    private String firstName;
    private String lastName;
    private String name;
    private int id;
    private double avg;
    private char letterGrade;
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    private static String[] labels = {"\n\tStudentServices.Student ID:","\n\tFirst Name: ","\n\tLast Name: ","\n\tGrades: ","\n\tAverage Grade: "};


// Getters
    public char getLetterGrade() {
        return this.letterGrade;
    }
    public String getName() {
        return this.name;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public int getId() {
        return this.id;
    }
    public double getAvg() {
        return this.avg;
    }
    public ArrayList getGrades() {
        return this.grades;
    }
    //Setters
    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }
    public void setName(String name) {
        this.name = name;
        String[] names = name.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAvg(float avg) {
        this.avg = avg;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setGrades(int[] grades) {
        for (int i: grades) {
            this.grades.add(i);
        }
    }

    //Special case functions
    public void addGrade( int grade){
        this.grades.add(grade);
        updateAvg();
    }
    public void removeGrade (int grade){
        this.grades.remove((Integer) grade);
    }
    public void updateAvg(){
        int sum = 0;
        double n = this.grades.size();
        for (Integer i : this.grades) {
            sum += i;
        }
        this.avg = (double) sum/n;
    }
    public void updateAvg(int[] grades){
        // overload for constructor, since adding a grade uses the arrayList
        int sum = 0;
        double n = grades.length;
        for (int i : grades) {
            sum += i;
        }
        this.avg = (double) sum/n;
    }
    public String toString(){
        return String.format(
                "%-16.16s%-16.16s%-16.16s%-16.16s%-16.16s%-16.16s%-16.16s%-16.25s%-16.16s%-16.16s",
                labels[0], this.id,
                labels[1], this.firstName,
                labels[2], this.lastName,
                labels[3], this.grades,
                labels[4], this.avg);
    }
}
