package org.sourceit.main;

import org.sourceit.db.DAO;
import org.sourceit.db.connection.MySQLConnection;
import org.sourceit.db.impl.PersonsDAOImpl;
import org.sourceit.entities.Person;

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

    }

}
