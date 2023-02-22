package com.example.urlHitCounter.controller;

import com.example.urlHitCounter.model.Visitor;
import com.example.urlHitCounter.service.UriHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/visitor-count-app")
public class UriHitController {

    @Autowired
    UriHitService uriHitService;

    @GetMapping(value = "/count")
    public String getHitCount(){
        return "Visitor "+uriHitService.getUriHitCount();
    }

    @GetMapping(value = "/username/{username}/count")
    public Visitor count(@PathVariable String username) {
        return uriHitService.fetchName(username);
    }

}
