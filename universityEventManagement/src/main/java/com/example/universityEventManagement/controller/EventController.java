package com.example.universityEventManagement.controller;

import com.example.universityEventManagement.model.EventModel;
import com.example.universityEventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event/v1")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/addEvent")
    public String addEvent(@RequestBody EventModel event){
        eventService.addEvent(event);
        return "Event Added Successfully";
    }

    @PutMapping("/updateEvent/")
    public String updateEvent(@RequestBody EventModel updateEvent, @RequestParam int id){
        eventService.updateEvent(id,updateEvent);
        return "Event Updated Successfully";
    }

    @DeleteMapping("/deleteEvent/")
    public String deleteEvent(@RequestParam(name = "id") int id){
        eventService.deleteEvent(id);
        return "Event Deleted Successfully";
    }

    @GetMapping("/getAllEvent")
    public List<EventModel> getAllEvent(){
        return eventService.getAllEvent();
    }

    @GetMapping("/getAllEventByDate")
    public List<EventModel> getByDate(@RequestParam(name = "date") String date){
        return eventService.getAllEventByDate(date);
    }

}
