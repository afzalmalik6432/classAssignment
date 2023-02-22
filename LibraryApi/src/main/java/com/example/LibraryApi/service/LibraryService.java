package com.example.LibraryApi.service;

import com.example.LibraryApi.dao.ILibraryDao;
import com.example.LibraryApi.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    ILibraryDao libraryDao;

    public Integer addLibrary(Library library){
        return libraryDao.save(library).getId();
    }

    public List<Library> getLibrary() {
        return libraryDao.findAll();
    }

    public Library getById(Integer id) {
        return libraryDao.findById(id).get();
    }

    public Library updatingExsistingData(Library exsitingLibrary, Library updateLibraryObject) {
        if(!exsitingLibrary.getName().equals(updateLibraryObject.getName()))
            exsitingLibrary.setName(updateLibraryObject.getName());
        if(!exsitingLibrary.getAddress().equals(updateLibraryObject.getAddress()))
            exsitingLibrary.setAddress(updateLibraryObject.getAddress());
        if(!exsitingLibrary.getNumber().equals(updateLibraryObject.getNumber()))
            exsitingLibrary.setNumber(updateLibraryObject.getNumber());
        if(!exsitingLibrary.getFacilities().equals(updateLibraryObject.getFacilities()))
            exsitingLibrary.setFacilities(updateLibraryObject.getFacilities());
        return exsitingLibrary;
    }
}
