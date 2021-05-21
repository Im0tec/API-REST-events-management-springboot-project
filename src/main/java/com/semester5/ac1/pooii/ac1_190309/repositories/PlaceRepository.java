package com.semester5.ac1.pooii.ac1_190309.repositories;

import java.util.List;

import com.semester5.ac1.pooii.ac1_190309.entities.Place;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <Place, Long>{
    
    List<Place> findByName(String name);

    @Query("SELECT e FROM Place e " +
            "WHERE " +
            " ( LOWER(e.name)          LIKE     LOWER(CONCAT('%', :name, '%')))           AND" + 
            " ( LOWER(e.address)         LIKE     LOWER(CONCAT('%', :address, '%')))             " )
    public Page<Place> findPlacesPageable(Pageable pageRequest, String name, String address);
}
