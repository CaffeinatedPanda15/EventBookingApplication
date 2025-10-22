package za.ac.cput.domain.eventdomains;


import za.ac.cput.domain.eventdomains.Catering;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;

    @Column
    private String eventName;
    @Column
    private String eventDescription;
    @Column
    private String eventLocation;
    @Column
    private String eventDate;
    @Column
    private String email;
    @Column
    private String contactNumber;
    @Column
    private String eventTime;

    @Column
    private String category;
    @Column
    private String status;

    protected Event() {
    }

    private Event(Builder builder) {
        this.eventId = builder.eventId;
        this.eventName = builder.eventName;
        this.eventDescription = builder.eventDescription;
        this.eventLocation = builder.eventLocation;
        this.eventDate = builder.eventDate;
        this.eventTime = builder.eventTime;
        this.category = builder.category;
        this.status = builder.status;
    }



    public long getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventLocation=" + eventLocation +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        private long eventId;
        private String eventName;
        private String eventDescription;
        private String eventLocation;
        private String eventDate;
        private Catering cater;
        private String email;
        private String phoneNumber;
        private String eventTime;
        private String category;
        private String status;

        public Builder setEventId(int eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public Builder setEventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
            return this;
        }

        public Builder setEventDate(String eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public Builder setEventTime(String eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Event build() {
            return new Event(this);
        }

        public Builder copy(Event event) {
            this.eventName = event.eventName;
            this.eventDescription = event.eventDescription;
            this.eventLocation = event.eventLocation;
            this.eventDate = event.eventDate;
            this.eventTime = event.eventTime;
            this.category = event.category;
            this.status = event.status;
            return this;
        }

    }//end of Builder

    @JsonCreator
    public static Event createFromJson(
            @JsonProperty("eventId") Integer eventId,
            @JsonProperty("eventName") String eventName,
            @JsonProperty("eventDescription") String eventDescription,
            @JsonProperty("eventLocation") String eventLocation,
            @JsonProperty("eventDate") String eventDate,
            @JsonProperty("eventTime") String eventTimeStr,       // accept string "HH:mm:ss"
            @JsonProperty("category") String category,
            @JsonProperty("status") String statusStr
    ) {
        Event.Builder b = new Event.Builder();
        if (eventId != null) b.setEventId(eventId);
        b.setEventName(eventName)
                .setEventDescription(eventDescription)
                .setEventLocation(eventLocation)
                .setEventDate(eventDate)
                .setCategory(category);

        if (eventTimeStr != null && !eventTimeStr.isBlank()) {
            b.setEventTime(eventTimeStr);
        }
        if (statusStr != null && !statusStr.isBlank()) {
            b.setStatus(statusStr);
        }
        return b.build();
    }


}//end of class
