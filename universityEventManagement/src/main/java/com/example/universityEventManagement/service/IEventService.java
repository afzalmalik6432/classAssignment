package com.example.universityEventManagement.service;

import com.example.universityEventManagement.model.EventModel;

import java.util.List;

public interface IEventService {
    void addEvent(EventModel event);
    List<EventModel> getAllEvent();
    void deleteEvent(int id);
    void updateEvent(int id, EventModel event);
    List<EventModel> getAllEventByDate(String date);
}
