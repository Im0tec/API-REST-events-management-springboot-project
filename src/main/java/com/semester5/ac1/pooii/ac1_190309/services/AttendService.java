/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.semester5.ac1.pooii.ac1_190309.dto.AttendDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AttendRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AttendUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Attend;
import com.semester5.ac1.pooii.ac1_190309.repositories.AttendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {

    @Autowired
    private AttendRepository repository;
    
    public Page<AttendDTO> getAttendees(PageRequest pageRequest, Double balance) {

        if(balance != null){
            Page <Attend> list = repository.findAttendeesBalancePageable(pageRequest, balance);
            return list.map( at -> new AttendDTO(at) );
        }
        else{
            Page <Attend> list = repository.findAttendeesPageable(pageRequest);
            return list.map( at -> new AttendDTO(at) );
        }
    }

    public AttendDTO getAttendById(Long id) {

        Optional<Attend> op = repository.findById(id);
        
        Attend attend = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found"));
        
        return new AttendDTO(attend);
    }

    public AttendDTO register(AttendRegisterDTO dto) {

        try{
            Attend entity = new Attend(dto);
            entity = repository.save(entity);
    
            return new AttendDTO(entity);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Sorry, it couldn't be create");
        }
    }

    public AttendDTO update(Long id, AttendUpdateDTO dto){

        try{

            Attend entity = repository.getOne(id);

            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());

            entity = repository.save(entity);

            return new AttendDTO(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
        
    }
    
}
