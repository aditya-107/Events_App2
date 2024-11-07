// Event.java
package androidsamples.java.eventsapp.models;

public class Event {
    private String eventName;
    private String eventDescription;
    private String eventDate;

    // Default constructor required for calls to DataSnapshot.getValue(Event.class)
    public Event() {
    }

    public Event(String eventName, String eventDescription, String eventDate) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}