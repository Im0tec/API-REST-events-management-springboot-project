/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.semester5.ac1.pooii.ac1_190309.dto.AdminDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AdminRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.dto.AdminUpdateDTO;
import com.semester5.ac1.pooii.ac1_190309.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/admins")
public class AdminController {
    
    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity<Page<AdminDTO>> getAdmins(
        
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
        @RequestParam(value = "phone", defaultValue = "") String phone
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Page<AdminDTO> list = service.getAdmins(pageRequest, phone);

        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id){
        
        AdminDTO dto = service.getAdminById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> register(@Valid @RequestBody AdminRegisterDTO registerDTO){

        AdminDTO dto = service.register(registerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id, @Valid @RequestBody AdminUpdateDTO updateDto){

        AdminDTO dto = service.update(id, updateDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
