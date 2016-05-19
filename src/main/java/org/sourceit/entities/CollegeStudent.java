package org.sourceit.entities;

public class CollegeStudent extends Student {

    protected int year;
    protected String major;

    public CollegeStudent(){
        this("Martin", 16, 'M', 5, 68.7, 2016, "Java");
    }

    public CollegeStudent(int year, String major) {
        this.year = year;
        this.major = major;
    }

    public CollegeStudent(String name, int age, char gender, int idNumber, double gpa, int year, String major) {
        super(name, age, gender, idNumber, gpa);
        this.year = year;
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", id_Number=" + idNumber +
                ", gpa=" + gpa +
                ", year=" + year +
                ", major='" + major + '\'' +
                '}';
    }
}
