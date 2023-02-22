package com.example.LibraryApi.controller;

import com.example.LibraryApi.model.Library;
import com.example.LibraryApi.service.LibraryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/api/v1")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping(value = "/library")
    public ResponseEntity<String> addLibrary(@RequestBody String requestObject){
        Library library = setLibrary(requestObject);
        return new ResponseEntity<>("Library Added with ID - "+libraryService.addLibrary(library), HttpStatus.CREATED);
    }

    @GetMapping(value = "/library")
    public ResponseEntity<List<Library>> getLibrary(){
        return new ResponseEntity<>(libraryService.getLibrary(), HttpStatus.OK);
    }
    @PutMapping(value = "/library")
    public ResponseEntity<String> updateLibrary(@RequestParam Integer id, @RequestBody String updateRequest){
        Library exsitingLibrary = libraryService.getById(id);
        Library updateLibraryObject = setLibrary(updateRequest);
        Library finalObjectToSave = libraryService.updatingExsistingData(exsitingLibrary,updateLibraryObject);
        return new ResponseEntity<>("Library Updated with ID - "+libraryService.addLibrary(finalObjectToSave), HttpStatus.OK);
    }

    private Library setLibrary(String requestObject) {
        JSONObject jsonObject = new JSONObject(requestObject);
        List<String> list = new ArrayList<>();
        Library library = new Library();
        library.setName(jsonObject.getString("name"));
        library.setAddress(jsonObject.getString("address"));
        JSONArray facilities = jsonObject.getJSONArray("facilities");
        for (Object obj:facilities) {
            list.add(obj.toString());
        }
        library.setFacilities(list);
        library.setNumber(jsonObject.getString("number"));
        return library;
    }
}
