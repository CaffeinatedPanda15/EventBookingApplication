package za.ac.cput.domain.eventdomains;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.sql.Time;
import java.time.LocalDateTime;

public class EventDTO {



        private long eventId;

        @NotNull(message = "Event Name cannot be null")
        private String eventName;
        @NotNull(message = "Event Description cannot be null")
        private String eventDescription;
        @NotNull(message = "Event Location cannot be null")
        private String eventLocation;
        @NotNull(message = "Event Date cannot be null")
        private String eventDate;
        @NotNull(message = "Event Time cannot be null")
        private Time eventTime;
        @NotNull(message = "Event Category cannot be null")
        private String category;

        private EventStatus status;

    public EventDTO() {
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
