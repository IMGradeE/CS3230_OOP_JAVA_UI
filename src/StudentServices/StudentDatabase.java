package StudentServices;

import java.util.*;

public class StudentDatabase {
    public StudentDatabase(){} // Should I have extended the map class or something instead?
    // This was way harder to implement than I thought it would be.
    private Map<Integer, Student> Students = new HashMap<>(){
        @Override
        public Student get(Object key) {
            return super.get(key);
        }
    };

    public boolean addStudent (Student student){
        try{
            if(Students.containsKey(student.getId())){
                throw new Exception(String.format("Could not add student with Id %d; Id already associated with student.", student.getId()));
            }
            Students.put(student.getId(), student);
            return true;

        }catch (RuntimeException IllegalArgumentException){
            System.out.println("Failed to add student to database. (Illegal Argument)");
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeStudent(int studentId){
        try{
            Students.remove(studentId);
            return true;
        }
        catch (Exception e){
            System.out.println("Failed to remove student from database using key-value.");
            return false;
        }
    }

    public Collection<Student> getStudents() {
        return Students.values();
    }

    public double calculateAverageGrade (int studentId){
        try {
            Student s = Students.get(studentId);
            return s.getAvg();
        }catch (Exception e){
            System.out.println("Operation failed: StudentServices.Student does not exist.");
        }
        return 0.0;
    }

    public Student getStudent(int studentId){
        try {
            return Students.get(studentId);
        }catch (Exception e){
            System.out.println("Operation failed: StudentServices.Student does not exist.");
            return null;
        }
    }

    public void printAllStudents(){
        for(Student s: this.getStudents()){
            System.out.println(s.toString());
        }
    }
}
