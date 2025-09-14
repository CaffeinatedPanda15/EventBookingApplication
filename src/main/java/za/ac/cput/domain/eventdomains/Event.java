package za.ac.cput.domain.eventdomains;



import jakarta.persistence.*;

import java.sql.Time;

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
    private Time eventTime;
    @Column
    private String category;
    @Column
    private EventStatus status;

    private Event() {
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

    public Time getEventTime() {
        return eventTime;
    }

    public String getCategory() {
        return category;
    }

    public EventStatus getStatus() {
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
        private int eventId;
        private String eventName;
        private String eventDescription;
        private String eventLocation;
        private String eventDate;
        private Time eventTime;
        private String category;
        private EventStatus status;

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

        public Builder setEventTime(Time eventTime) {
            this.eventTime = eventTime;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setStatus(EventStatus status) {
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
}//end of class
