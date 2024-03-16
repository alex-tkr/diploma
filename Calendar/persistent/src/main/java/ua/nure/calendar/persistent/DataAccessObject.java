package ua.nure.calendar.persistent;

import java.util.Optional;

public interface DataAccessObject<E extends Entity> {

    void create(E entity);

    Optional<E> findById(String id);

    void update(E entity);

    void delete(String id);
}
