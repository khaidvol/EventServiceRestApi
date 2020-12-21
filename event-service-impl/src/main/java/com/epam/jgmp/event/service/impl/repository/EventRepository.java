package com.epam.jgmp.event.service.impl.repository;

import com.epam.jgmp.event.service.dto.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

  List<Event> findByTitle(String string);
}
