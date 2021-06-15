package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JSONSerializationDemo  {

    private Map<Long, Book> bookMap = new HashMap<>();
//    private String bookJson;
    private ObjectMapper objectMapper = new ObjectMapper();
//    private final String FILE_NAME = "book.json";
    File file = new File("book.json");

    public JSONSerializationDemo(){

    }

    public void addBook(Book book) throws IOException {
        bookMap.put(book.getId(),book);
        System.out.println("Book has been successfully added\n" + book + "\n");
    }

    public void deleteBook(long bookId) throws IOException {
        bookMap.remove(bookId);
        System.out.println("Book has been successfully deleted\n");
    }

    public void showAllBooks() throws IOException {
        bookMap.forEach((key, value) -> System.out.println(value));
        System.out.println();
    }

    public void retrieveAllBooks() throws IOException {
//        File file = new File(FILE_NAME);
        String bookJson = inputStreamToString(new FileInputStream(file));
        bookMap = objectMapper.readValue(bookJson, new TypeReference<Map<Long, Book>>() {
        });
    }

    public void saveBooksToFile() throws IOException {
//        objectMapper.writeValue(new File(FILE_NAME), bookMap);
        objectMapper.writeValue(file, bookMap);
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


}
