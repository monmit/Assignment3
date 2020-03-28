package com.techstack.monica.service;

import com.techstack.monica.domain.Book;
import com.techstack.monica.domain.Student;

import java.util.Scanner;

public class InputOutputImpl {

    public int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public Student getStudentDetails() {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Please enter the firstName below:");
        //String firstName = scanner.next();
        /*System.out.println("Please enter the LastName below:");
        String lastName = scanner.next();
        //Integer id = getIdFromUser();
        System.out.println("Please enter the ClassDivision below:");
        String classDivision = scanner.next();*/
        Integer rollNumber = getRollNumberFromUser();
        Student student = new Student("Monica", "mittal", "2", rollNumber);
        return student;
    }
    public Integer getRollNumberFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the rollNumber Below:");
        Integer rollNumber = scanner.nextInt();
        while(rollNumber < 0){
            System.out.println("Incorrect Roll Number. Roll Number should be greater than 0, Enter Roll Number again:");
            rollNumber = scanner.nextInt();
        }
        return rollNumber;
    }

    public Book getBooksDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Title of the Book:");
        String title = scanner.next();
        System.out.println("Please enter the Author of the Book:");
        String author = scanner.next();
        Book book = new Book(title,author);
        return book;
    }

    public Integer getBookId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the book id:");
        Integer id = scanner.nextInt();
        while(id < 0){
            System.out.println("id cannot be negative. please enter again:");
            id = scanner.nextInt();
        }
        return id;
    }


}
