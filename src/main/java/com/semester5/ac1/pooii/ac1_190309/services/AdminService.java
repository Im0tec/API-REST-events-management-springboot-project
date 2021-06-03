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

import com.semester5.ac1.pooii.ac1_190309.dto.AdminDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AdminRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AdminUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.Admin;
import com.semester5.ac1.pooii.ac1_190309.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Page<AdminDTO> getAdmins(PageRequest pageRequest, String phone) {

        Page <Admin> list = repository.findAdminsPageable(pageRequest, phone);

        return list.map( admin -> new AdminDTO(admin) );
    }

    public AdminDTO getAdminById(Long id) {

        Optional<Admin> op = repository.findById(id);
        
        Admin admin = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));
        
        return new AdminDTO(admin);
    }

    public AdminDTO register(AdminRegisterDTO dto) {

        checkEmail(dto.getEmail());
        Admin entity = new Admin(dto);
        entity = repository.save(entity);
        
        return new AdminDTO(entity);
        
    }

    public AdminDTO update(Long id, AdminUpdateDTO dto){

        checkEmail(dto.getEmail());
        Admin entity = repository.getOne(id);

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());

        entity = repository.save(entity);

        return new AdminDTO(entity);
        
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
        
    }

    public void checkEmail(String email){
        Optional<Admin> admin = repository.findByEmail(email);

        if(!admin.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email inserted has already been registred");
        }
    }
    
}
