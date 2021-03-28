/*
 * NOME: Eduardo Campos Gonçalves - 190309
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.repositories;

import java.time.LocalDate;
import java.util.List;

import com.semester5.ac1.pooii.ac1_190309.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event,Long>{
    
    List<Event> findByName(String name);

    @Query("SELECT e FROM Event e " +
            "WHERE " +
            " ( LOWER(e.name)          LIKE     LOWER(CONCAT('%', :name, '%')))           AND" + 
            " ( LOWER(e.place)         LIKE     LOWER(CONCAT('%', :place, '%')))          AND" +
            " ( LOWER(e.description)   LIKE     LOWER(CONCAT('%', :description, '%')))       " )
    public Page<Event> findEventPageable(Pageable pageRequest, String name, String place, String description);

    @Query( "SELECT e FROM Event e " +
            "WHERE " +
            " ( LOWER(e.name)          LIKE     LOWER(CONCAT('%', :name, '%')))           AND" + 
            " ( LOWER(e.place)         LIKE     LOWER(CONCAT('%', :place, '%')))          AND" +
            " ( LOWER(e.description)   LIKE     LOWER(CONCAT('%', :description, '%')))    AND" +
            " ( e.start_date              >                        :startDate)                " )

    public Page<Event> findEventPageable_Date(Pageable pageRequest, String name, String place, String description, LocalDate startDate);
}
