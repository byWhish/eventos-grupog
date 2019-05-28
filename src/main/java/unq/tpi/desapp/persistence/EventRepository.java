package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.event.Event;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Query(nativeQuery = true, value="SELECT TOP 15 e.* FROM Event e join Guest g on e.id = g.event_id " +
            "where g.user_id = :userId " +
            "order by e.created_at desc ")
    List<Event> findLastest(@Param("userId") Long userId);

    @Query(nativeQuery = true, value="SELECT e.* FROM Event e join Guest g on e.id = g.event_id " +
            "where e.held_at > TODAY " +
            "and g.user_id = :userId " +
            "order by e.created_at desc ")
    List<Event> findOngoing(@Param("userId") Long userId);

    @Query(nativeQuery = true, value="SELECT TOP 15 e.* FROM Event e join " +
            "(SELECT g.event_id, COUNT(CASE WHEN g.confirmed_assistance THEN 1 END) assistance_count " +
            "FROM Guest g GROUP BY g.event_id) AS counter ON counter.event_id = e.id " +
            "where e.held_at > TODAY " +
            "order by counter.assistance_count desc, e.created_at desc ")
    List<Event> findPopular();
}