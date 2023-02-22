package com.example.LibraryApi.dao;

import com.example.LibraryApi.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryDao extends JpaRepository<Library,Integer> {

}
