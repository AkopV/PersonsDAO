package org.sourceit.db.impl;

import org.sourceit.db.DAO;
import org.sourceit.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements DAO<Student> {

    private Connection connection;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Student entity) {
        boolean created = false;
        try (PreparedStatement preparedStatement =
        connection.prepareStatement("INSERT INTO student(name, age, gender, id_Number, gpa) VALUES(?, ?, ?, ?, ?) ")){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, "" + entity.getGender());
            preparedStatement.setInt(4, entity.getIdNumber());
            preparedStatement.setDouble(5, entity.getGpa());

            created = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean update(Student entity) {
        boolean updated = false;

        try(PreparedStatement preparedStatement =
        connection.prepareStatement("UPDATE student SET name=?, age=?, gender=?, id_Number=?, gpa=? " + "WHERE student_id=?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, entity.getGender() + "");
            preparedStatement.setInt(4, entity.getIdNumber());
            preparedStatement.setDouble(5, entity.getGpa());
            preparedStatement.setInt(6, (int) entity.getId());

            updated = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public List<Student> list() {
        List<Student> students = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender").charAt(0));
                student.setIdNumber(resultSet.getInt("id_Number"));
                student.setGpa(resultSet.getDouble("gpa"));
                students.add(student);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean remove(Student entity) {
        boolean removed = false;
        try(PreparedStatement preparedStatement =
        connection.prepareStatement("DELETE FROM student WHERE student_id=?")){
            preparedStatement.setInt(1, (int) entity.getId());
            removed = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return removed;
    }
}
