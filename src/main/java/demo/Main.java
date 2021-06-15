package demo;

import controller.BookController;
import model.Book;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookController controller = new BookController();
        controller.retrieveAllBooks();
        Book book = new Book();
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("To show all books:  1\t" + "To create a new book:  2\t" + "To delete a book:  3\t" + "To exit:  0");
            String inputStr = input.next();
            switch (inputStr){
                case "1":
                    controller.showAllBooks();
                    break;
                case "2":
                    System.out.println("Enter ID:");
                    book.setId(input.nextLong());
                    System.out.println("Enter book title:");
                    book.setTitle(input.next());
                    System.out.println("Enter book ISBN:");
                    book.setIsbn(input.next());
                    System.out.println("Enter book author:");
                    book.setAuthor(input.next());
                    controller.addBook(book);
                    break;
                case "3":
                    System.out.println("Enter ID:");
                    controller.deleteBook(input.nextLong());
                case "0":
                    controller.saveBooksToFile();
                    break;
            }
            if (inputStr.equals("0")) break;
        }

    }

}
