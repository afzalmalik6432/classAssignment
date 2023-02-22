package com.example.urlHitCounter.service;

import com.example.urlHitCounter.model.Visitor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UriHitService {
    public static Integer hit=0;
    int count=1;
    HashMap<String  ,Integer> hm=new HashMap<>();

    public int getUriHitCount() {
        return ++hit;
    }
    public Visitor fetchName(String username) {
        count=hm.getOrDefault(username, 0)+1;
        hm.put(username, count);
        return new Visitor(username,count);
    }
}
