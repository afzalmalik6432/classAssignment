package com.example.universityEventManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;
    private String eventName;
    private String locationOfEvent;
    private String date;
    private String startTime;
    private String endTime;
//    private String imageUrl;;
}
