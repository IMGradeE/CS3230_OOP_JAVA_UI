public final class Student {
    public Student() {
    }// Returns an instance of the Student class
    private String name;
    private String id;
    private float avg;
    private char letterGrade;

    public char getLetterGrade() {
        return this.letterGrade;
    }
    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public float getAvg() {
        return this.avg;
    }
    public void setAvg(float avg) {
        this.avg = avg;
    }
}
