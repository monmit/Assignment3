package com.techstack.monica.service;

import com.techstack.monica.dao.BookDAO;
import com.techstack.monica.dao.StudentBookDAO;
import com.techstack.monica.domain.Book;
import com.techstack.monica.domain.StudentBookMapping;

import java.util.List;


public class LibraryService {
    InputOutputImpl inputOutput = new InputOutputImpl();
    BookDAO bookdao = new BookDAO();
    StudentBookDAO studentBookdao = new StudentBookDAO();
    //StudentBookMapping studentBookMapping = new StudentBookMapping();

    public void addBook() {
        try {
        Book book = inputOutput.getBooksDetails();
        Integer id = book.getId();
        List<Book> books = bookdao.getBooks();
            for(Book b : books) {
                Integer bookIdFromDB = b.getId();
                if (id == bookIdFromDB) {
                    System.out.println("Book with this id already exists");
                    book = inputOutput.getBooksDetails();
                } else {
                    bookdao.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteBook(int id){
       try{
           bookdao.delete(id);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void issueBook(int studentId) {
        try {
            Book input = inputOutput.getBooksDetails();
            List<Integer> allBookIds = studentBookdao.getBookIds(input.getAuthor(), input.getTitle());
            if(allBookIds.isEmpty()) {
                System.out.println("No book with given title and author exist");
            } else {
                List<Integer> issuedBooks = studentBookdao.getIssuedBookIds(allBookIds);
                boolean allBooksIssued = true;
                for (int bookId : allBookIds) {
                    if (!issuedBooks.contains(bookId)) {
                        allBooksIssued = false;
                        studentBookdao.issueBookToStudent(bookId, studentId);
                        break;
                    }
                }

                if(allBooksIssued) {
                    System.out.println("Sorry at the moment all books are issued for given author and title, come back later");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
