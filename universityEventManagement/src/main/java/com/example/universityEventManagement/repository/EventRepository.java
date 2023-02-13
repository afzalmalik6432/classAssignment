package com.example.universityEventManagement.repository;

import com.example.universityEventManagement.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventModel,Integer> {
    List<EventModel> findByDate(String date);
}
