package ua.nure.calendar.services.event;

import ua.nure.calendar.persistent.event.EventDao;
import ua.nure.calendar.persistent.event.EventEntity;
import ua.nure.calendar.services.AccessForbidden;
import ua.nure.calendar.services.DataNotFound;


import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import static java.lang.String.format;

public class EventService {

    private final EventDao eventDao;

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public String createEvent(Date eventDate,
                           String name,
                           String description,
                           Time startTime,
                           Time enrTime,
                           double price, String idAuthor) {
        var newEvent = new EventEntity(
                UUID.randomUUID().toString(),
                eventDate,
                name,
                description,
                startTime,
                enrTime,
                price,
                idAuthor
        );

        eventDao.create(newEvent);

        return newEvent.id();
    }

    public void editEvent(String idUser, String idEvent, Date eventDate,
                          String name,
                          String description,
                          Time startTime,
                          Time endTime,
                          double price)
            throws DataNotFound, AccessForbidden {
        var event = eventDao.findById(idEvent);
        if(event.isEmpty()){
            throw new DataNotFound("Event " + idEvent + " doesn't exist.");
        }
        if(event.get().idAuthor() != idUser) {
            throw new AccessForbidden("You don't have rights to edit this event!");
        }
        var editedEvent = new EventEntity(idEvent, eventDate, name, description, startTime, endTime, price, idUser);
        eventDao.update(editedEvent);
    }

    public void deleteEvent(String idUser, String idEvent) throws DataNotFound, AccessForbidden{
        var event = eventDao.findById(idEvent);
        if(event.isEmpty()){
            throw new DataNotFound("Event " + idEvent + " doesn't exist.");
        }
        if(event.get().idAuthor() != idUser) {
            throw new AccessForbidden("You don't have rights to edit this event!");
        }
        eventDao.delete(idEvent);
    }
}
