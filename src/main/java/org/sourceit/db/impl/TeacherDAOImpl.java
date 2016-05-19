package org.sourceit.db.impl;

import org.sourceit.db.DAO;
import org.sourceit.entities.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements DAO<Teacher> {

    private Connection connection;

    public TeacherDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Teacher entity) {
        boolean created = false;
        try(PreparedStatement preparedStatement =
        connection.prepareStatement("INSERT INTO teacher(name, age, gender, salary, subject) VALUES(?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, "" + entity.getGender());
            preparedStatement.setInt(4, entity.getSalary());
            preparedStatement.setString(5, entity.getSubject());

            created = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean update(Teacher entity) {
        boolean updated = false;

        try(PreparedStatement preparedStatement =
        connection.prepareStatement("UPDATE teacher SET name=?, age=?, gender=?, salary=?, subject=?" +
        "WHERE teacher_id=?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, "" + entity.getGender());
            preparedStatement.setInt(4, entity.getSalary());
            preparedStatement.setString(5, entity.getSubject());
            preparedStatement.setInt(6, (int) entity.getId());

            updated = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public List<Teacher> list() {
        List<Teacher> teachers = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TEACHER");
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("teacher_id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setGender(resultSet.getString("gender").charAt(0));
                teacher.setSalary(resultSet.getInt("salary"));
                teacher.setSubject(resultSet.getString("subject"));
                teachers.add(teacher);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public boolean remove(Teacher entity) {
        boolean removed = false;
        try(PreparedStatement preparedStatement =
        connection.prepareStatement("DELETE FROM teacher WHERE teacher_id=?")){
            preparedStatement.setInt(1, (int) entity.getId());
            removed = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return removed;
    }
}
