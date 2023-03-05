package com.example.hibernateMapping.dao;

import com.example.hibernateMapping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
