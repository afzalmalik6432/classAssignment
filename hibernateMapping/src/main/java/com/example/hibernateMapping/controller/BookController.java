package com.example.hibernateMapping.controller;

import com.example.hibernateMapping.dao.IStudentRepository;
import com.example.hibernateMapping.model.Book;
import com.example.hibernateMapping.model.Student;
import com.example.hibernateMapping.service.BookService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    IStudentRepository studentRepository;

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody String requestBook){
        Book book = setBook(requestBook);
        Integer bookId = service.saveBook(book);
        return new ResponseEntity<>("Book saved with id - " + bookId, HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<String> getBook(@Nullable @RequestParam Integer bookId){
        List<Book> books = service.getBook(bookId);
        return new ResponseEntity<>(books.toString(),HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> updateBook(@RequestParam Integer bookId, @RequestBody String requestBook){
        Book book = setBook(requestBook);
        book.setID(bookId);
        service.saveBook(book);
        return new ResponseEntity<>("Book is updated successfully of id - "+bookId,HttpStatus.OK);
    }

    @DeleteMapping("/book")
    public ResponseEntity<String> deleteBook(@RequestParam Integer bookId){
        service.deleteBook(bookId);
        return new ResponseEntity<>("Book is deleted successfully of id - "+bookId,HttpStatus.OK);
    }

    private Book setBook(String requestBook) {
        Book book = new Book();
        JSONObject json = new JSONObject(requestBook);
        book.setAuthor(json.getString("author"));
        book.setTitle(json.getString("title"));
        book.setDescription(json.getString("description"));
        book.setPrice(json.getInt("price"));
        Integer studentId = json.getInt("studentId");
        Student student = studentRepository.findById(studentId).get();
        book.setStudent(student);

        return book;
    }
}