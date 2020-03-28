package com.techstack.monica.dao;

import com.techstack.monica.domain.StudentBookMapping;
import com.techstack.monica.util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentBookDAO {
    DBConnector connection = new DBConnector();
    Statement statement;
    public ResultSet resultSet;

    public List<Integer> getBookIds(String bookByAuthor, String bookByTitle) throws Exception{
        List<Integer> bookId = new ArrayList<>();
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Select * from studentBookMapping Where author = " + bookByAuthor + " AND " + "title = " + bookByTitle);
        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            bookId.add(id);
        }
        return bookId;
    }

    public List<Integer> getIssuedBookIds(List<Integer> id) throws Exception {
        List<Integer> issuedBookIds = new ArrayList<>();
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Select * from studentBookMapping where id IN (" + id + ") AND dueDate = Null" );
        while(resultSet.next()){
            Integer bookId = resultSet.getInt("bookId");
            issuedBookIds.add(bookId);
        }
        return issuedBookIds;

    }

    public void issueBookToStudent(int bookId, int studentId) throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Update studentBookMapping Set issue_date = 1, due_date = 2 Where book_id = " + bookId + " AND " + "student_id = " + studentId);
    }
}
