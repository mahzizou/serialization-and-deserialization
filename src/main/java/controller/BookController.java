package controller;

import dao.JSONSerializationDemo;
import model.Book;

import java.io.IOException;

public class BookController {

    JSONSerializationDemo bookDAO = new JSONSerializationDemo();

    public void addBook(Book book){
        try {
            bookDAO.addBook(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(long bookId){
        try {
            bookDAO.deleteBook(bookId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllBooks(){
        try {
            bookDAO.showAllBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrieveAllBooks(){
        try {
            bookDAO.retrieveAllBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveBooksToFile(){
        try {
            bookDAO.saveBooksToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
