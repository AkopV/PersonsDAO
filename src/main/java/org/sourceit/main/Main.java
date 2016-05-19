package org.sourceit.main;

import org.sourceit.db.DAO;
import org.sourceit.db.connection.MySQLConnection;
import org.sourceit.db.impl.CollegeStudentDAOImpl;
import org.sourceit.db.impl.PersonsDAOImpl;
import org.sourceit.db.impl.StudentDAOImpl;
import org.sourceit.db.impl.TeacherDAOImpl;
import org.sourceit.entities.CollegeStudent;
import org.sourceit.entities.Person;
import org.sourceit.entities.Student;
import org.sourceit.entities.Teacher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        MySQLConnection mySQLConnection = MySQLConnection.INSTANCE;

        DAO<Person> personDAO = new PersonsDAOImpl(mySQLConnection.getConnection());

        System.out.println(personDAO.list());

        List<Person> persons = personDAO.list();

        for (Person person : persons) {
            personDAO.remove(person);
        }

        System.out.println(personDAO.list());

        Person person1 = new Person("Oleg 1", 40, 'F');
        Person person2 = new Person("Mash 1", 34, 'F');

        personDAO.create(person1);
        personDAO.create(person2);

        System.out.println(personDAO.list());

        List<Person> personList = personDAO.list();

        personList.get(0).setName("Oleg");
        personList.get(0).setAge(24);
        personList.get(0).setGender('M');

        personDAO.update(personList.get(0));

        System.out.println(personDAO.list());

        DAO<Teacher> teacherDAO = new TeacherDAOImpl(mySQLConnection.getConnection());

        System.out.println(teacherDAO.list());

        List<Teacher> teachers = teacherDAO.list();

        for(Teacher teacher : teachers){
            teacherDAO.remove(teacher);
        }

        System.out.println(teacherDAO.list());

        Teacher teacher1 = new Teacher("Aristotel", 45, 'M', 7000, "Mathematic");
        Teacher teacher2 = new Teacher("Maria", 25, 'F', 4500, "OOP");

        teacherDAO.create(teacher1);
        teacherDAO.create(teacher2);

        System.out.println(teacherDAO.list());

        List<Teacher> teacherList = teacherDAO.list();

        teacherList.get(0).setName("Arti");
        teacherList.get(0).setAge(45);
        teacherList.get(0).setGender('M');
        teacherList.get(0).setSalary(8000);
        teacherList.get(0).setSubject("Logic");

        teacherDAO.update(teacherList.get(0));

        System.out.println(teacherDAO.list());

        DAO<Student> studentDAO = new StudentDAOImpl(mySQLConnection.getConnection());

        System.out.println(studentDAO.list());

        List<Student> students = studentDAO.list();

        for(Student student : students){
            studentDAO.remove(student);
        }

        System.out.println(studentDAO.list());

        Student student1 = new Student("Akop", 29, 'M', 1, 89.9);
        Student student2 = new Student("Masha", 25, 'F', 2, 75.8);

        studentDAO.create(student1);
        studentDAO.create(student2);

        System.out.println(studentDAO.list());

        List<Student> studentList = studentDAO.list();

        studentList.get(0).setName("Artur");
        studentList.get(0).setAge(29);
        studentList.get(0).setGender('M');
        studentList.get(0).setId(3);
        studentList.get(0).setGpa(99.9);

        studentDAO.update(studentList.get(0));

        System.out.println(studentDAO.list());

        DAO<CollegeStudent> collegeStudentDAO = new CollegeStudentDAOImpl(mySQLConnection.getConnection());

        System.out.println(collegeStudentDAO.list());

        List<CollegeStudent> collegeStudents = collegeStudentDAO.list();

        for (CollegeStudent collegeStudent : collegeStudents){
            collegeStudentDAO.remove(collegeStudent);
        }

        System.out.println(collegeStudentDAO.list());

        CollegeStudent collegeStudent1 = new CollegeStudent("Mark", 17, 'M', 5, 58.98, 2016, "ANDROID");
        CollegeStudent collegeStudent2 = new CollegeStudent("Daeneris", 19, 'F', 7, 98.58, 2016, "GAME_OF_TRONES");

        collegeStudentDAO.create(collegeStudent1);
        collegeStudentDAO.create(collegeStudent2);

        System.out.println(collegeStudentDAO.list());

        List<CollegeStudent> collegeStudentList = collegeStudentDAO.list();

        collegeStudentList.get(0).setName("Serceya");
        collegeStudentList.get(0).setAge(18);
        collegeStudentList.get(0).setGender('F');
        collegeStudentList.get(0).setIdNumber(8);
        collegeStudentList.get(0).setGpa(98.88);
        collegeStudentList.get(0).setYear(2016);
        collegeStudentList.get(0).setMajor("GameTronies");

        collegeStudentDAO.update(collegeStudentList.get(0));

        System.out.println(collegeStudentDAO.list());
    }

}
