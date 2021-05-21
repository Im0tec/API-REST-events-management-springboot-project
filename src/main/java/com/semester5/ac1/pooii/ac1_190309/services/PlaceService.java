package com.semester5.ac1.pooii.ac1_190309.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.semester5.ac1.pooii.ac1_190309.dto.PlaceDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.PlaceRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.PlaceUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Place;
import com.semester5.ac1.pooii.ac1_190309.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repository;

    public Page<PlaceDTO> getPlaces(PageRequest pageRequest, String name, String address){

        Page <Place> list = repository.findPlacesPageable(pageRequest, name, address);

        return list.map( p -> new PlaceDTO(p) );
    }

    public PlaceDTO getPlaceById(Long id) {

        Optional<Place> op = repository.findById(id);

        Place place = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));
        
        return new PlaceDTO(place);
    }

    public PlaceDTO register(PlaceRegisterDTO dto) {

        try{
    
            Place entity = new Place(dto);
            entity = repository.save(entity);
    
            return new PlaceDTO(entity);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Sorry, it couldn't be create");
        }
    }

    public PlaceDTO update(Long id, PlaceUpdateDTO dto){

        try{

            Place entity = repository.getOne(id);

            entity.setName(dto.getName());

            entity = repository.save(entity);

            return new PlaceDTO(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        }
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        }
        
    }
}
