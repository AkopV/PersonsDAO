package org.sourceit.entities;

public class Student extends Person {

    protected int idNumber;
    protected double gpa;

    public Student(){
        this("Aristarh", 18, 'M', 21, 11.5);
    }

    public Student(int idNumber, double gpa) {
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public Student(String name, int age, char gender, int idNumber, double gpa) {
        super(name, age, gender);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa > 1 && gpa <= 100){
            this.gpa = gpa;
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                ", id_Number=" + idNumber +
                ", gpa=" + gpa +
                '}';
    }
}
