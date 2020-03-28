package com.techstack.monica;


import com.techstack.monica.service.InputOutputImpl;
import com.techstack.monica.service.LibraryService;
import com.techstack.monica.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentservice = new StudentService();
        LibraryService libraryService = new LibraryService();
        InputOutputImpl userInput = new InputOutputImpl();

        int option = userInput.getUserInput();
        if (option == 1) {
            studentservice.addStudent();
        } else if (option == 2) {
            studentservice.deleteStudent(userInput.getRollNumberFromUser());
        } else if (option == 3) {
            libraryService.addBook();
        } else if (option == 4) {
            libraryService.deleteBook(userInput.getBookId());
        } else if (option == 5) {
            libraryService.issueBook(userInput.getStudentDetails().getId());
        }
    }
}