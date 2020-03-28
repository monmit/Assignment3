package com.techstack.monica.dao;

import com.techstack.monica.domain.Book;
import com.techstack.monica.util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    DBConnector connection = new DBConnector();
    Statement statement;
    ResultSet resultSet;

    public List<Book> getBooks() throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        resultSet = statement.executeQuery("Select * from book");
        List<Book> books = new ArrayList<>();
        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            String title = resultSet.getString("Title");
            String author = resultSet.getString("Author");
            Book book = new Book(id, title, author);
            books.add(book);
        } return books;

    }

    public void add(Book book) throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        String query = "";
        resultSet = statement.executeQuery(query);

    }

    public void delete(int id) throws Exception {
        Connection connect = connection.getConnection();
        statement = connect.createStatement();
        String query = "";
        resultSet = statement.executeQuery(query);

    }

}
