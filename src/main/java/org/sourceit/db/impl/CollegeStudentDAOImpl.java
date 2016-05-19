package org.sourceit.db.impl;

import org.sourceit.db.DAO;
import org.sourceit.entities.CollegeStudent;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollegeStudentDAOImpl implements DAO<CollegeStudent> {

    private Connection connection;

    public CollegeStudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(CollegeStudent entity) {
        boolean created = false;
        try (PreparedStatement preparedStatement =
        connection.prepareStatement("INSERT INTO college_Student(name, age, gender, id_Number, gpa, year, major) VALUES(?, ?, ?, ?, ?, ?, ?) ")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, "" + entity.getGender());
            preparedStatement.setInt(4, entity.getIdNumber());
            preparedStatement.setDouble(5, entity.getGpa());
            preparedStatement.setInt(6, (int) entity.getYear());
            preparedStatement.setString(7, entity.getMajor());

            created = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return created;
    }

    @Override
    public boolean update(CollegeStudent entity) {
        boolean updated = false;

        try (PreparedStatement preparedStatement =
        connection.prepareStatement("UPDATE college_student SET name=?, age=?, gender=?, id_Number=?, gpa=?, year=?, major=? " + "WHERE college_student_id=?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.setString(3, entity.getGender() + "");
            preparedStatement.setInt(4, entity.getIdNumber());
            preparedStatement.setDouble(5, entity.getGpa());
            preparedStatement.setInt(6, (int) entity.getYear());
            preparedStatement.setString(7, entity.getMajor());
            preparedStatement.setInt(8, (int) entity.getId());

            updated = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public List<CollegeStudent> list() {
        List<CollegeStudent> collegeStudents = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM COLLEGE_STUDENT");
            while(resultSet.next()) {
                CollegeStudent collegeStudent = new CollegeStudent();
                collegeStudent.setId(resultSet.getInt("college_student_id"));
                collegeStudent.setName(resultSet.getString("name"));
                collegeStudent.setAge(resultSet.getInt("age"));
                collegeStudent.setGender(resultSet.getString("gender").charAt(0));
                collegeStudent.setIdNumber(resultSet.getInt("id_Number"));
                collegeStudent.setGpa(resultSet.getDouble("gpa"));
                collegeStudent.setYear(resultSet.getInt("year"));
                collegeStudent.setMajor(resultSet.getString("major"));
                collegeStudents.add(collegeStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collegeStudents;
    }

    @Override
    public boolean remove(CollegeStudent entity) {
        boolean removed = false;
        try(PreparedStatement preparedStatement =
        connection.prepareStatement("DELETE FROM college_student WHERE college_student_id=?")){
            preparedStatement.setInt(1, (int) entity.getId());
            removed = preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return removed;
    }
}
