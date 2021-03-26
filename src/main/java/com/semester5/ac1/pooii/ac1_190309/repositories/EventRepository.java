package com.semester5.ac1.pooii.ac1_190309.repositories;

import java.util.List;

import com.semester5.ac1.pooii.ac1_190309.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event,Long>{
    
    List<Event> findByName(String name);
}
