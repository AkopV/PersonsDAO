package org.sourceit.entities;

public class Teacher extends Person {

    protected int salary;
    protected String subject;

    public Teacher() {
        this("Ivan", 50, 'M', 5000, "Math");
    }

    public Teacher(int salary, String subject) {
        this.salary = salary;
        this.subject = subject;
    }

    public Teacher(String name, int age, char gender, int salary, String subject) {
        super(name, age, gender);
        this.salary = salary;
        this.subject = subject;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary > 1500 && salary < 10000) {
            this.salary = salary;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
