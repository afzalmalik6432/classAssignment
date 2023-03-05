package com.example.hibernateMapping.service;

import com.example.hibernateMapping.dao.IBookRepository;
import com.example.hibernateMapping.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookRepository bookRepository;
    @Autowired
    StudentService studentService;
    public Integer saveBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook.getID();
    }

    public List<Book> getBook(Integer bookId) {
        List<Book> books = new ArrayList<>();
        if(bookId!=null){
            books.add(bookRepository.findById(bookId).get()) ;
        }else {
            books = bookRepository.findAll();
        }
        return books;
    }

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}