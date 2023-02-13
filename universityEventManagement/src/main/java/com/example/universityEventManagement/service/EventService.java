package com.example.universityEventManagement.service;

import com.example.universityEventManagement.model.EventModel;
import com.example.universityEventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService{

    @Autowired
    EventRepository eventRepository;

    @Override
    public void addEvent(EventModel event) {
        eventRepository.save(event);
    }

    @Override
    public List<EventModel> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void updateEvent(int id, EventModel updateEventObject) {
        EventModel event = eventRepository.findById(id).get();
        event.setDate(updateEventObject.getDate());
        event.setEventName(updateEventObject.getEventName());
        event.setLocationOfEvent(updateEventObject.getLocationOfEvent());
        event.setStartTime(updateEventObject.getStartTime());
        event.setEndTime(updateEventObject.getEndTime());
        eventRepository.save(event);
    }

    @Override
    public List<EventModel> getAllEventByDate(String date) {
        return eventRepository.findByDate(date);
    }
}
