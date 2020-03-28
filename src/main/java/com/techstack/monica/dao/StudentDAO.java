package com.techstack.monica.dao;

import com.techstack.monica.domain.Student;
import com.techstack.monica.util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    DBConnector connection = new DBConnector();
    Statement statement;
    public ResultSet resultSet;

    public List<Student> getStudents()throws Exception{
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Select * from student");
        List<Student> students = new ArrayList<>();
        while(resultSet.next()){
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String classDivision = resultSet.getString("classDivision");
            int id = resultSet.getInt("id");
            int rollNumber = resultSet.getInt("RollNumber");
            Student student = new Student(id, firstName, lastName, classDivision, rollNumber);
            students.add(student);
        }
        return students;
    }

    public Student getStudentByRollNumber(int rollNumber) throws Exception{
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Select * from student where rollNumber = " + rollNumber);
        List<Student> studentList = new ArrayList<>();
        while(resultSet.next()){
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String classDivision = resultSet.getString("classDivision");
            int id = resultSet.getInt("id");
            int rollNumberFromDB = resultSet.getInt("RollNumber");
            Student student = new Student(id, firstName, lastName, classDivision, rollNumberFromDB);
            studentList.add(student);
        }
        return studentList.isEmpty() ? null : studentList.get(0);
    }

    public void add(Student student) throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        String query =  "Insert into student(firstName, lastName, classDivision, RollNumber)" +
                " Values('" + student.getFirstName() + "','" + student.getLastName() + "','" + student.getClassDivision()+ "','" + student.getRollNumber() + "');" ;
        statement.executeUpdate(query);
        connect.close();
    }
    public void delete(int rollNumber)throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        String query = "Delete from student Where rollNumber = " + rollNumber;
        resultSet = statement.executeQuery(query);
        connect.close();
    }
}
