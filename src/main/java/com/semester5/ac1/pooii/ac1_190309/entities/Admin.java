/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semester5.ac1.pooii.ac1_190309.dto.AdminsDTO.AdminRegisterDTO;

@Entity
@Table(name = "TB_ADMIN")
@PrimaryKeyJoinColumn(name = "BASEUSER_ID")
public class Admin extends BaseUser{
    
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "admin")
    private List<Event> events = new ArrayList<>();

    public Admin() {
    }

    public Admin(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin(String name, String email, String phoneNumber) {
        super(name, email);
        this.phoneNumber = phoneNumber;
    }

    public Admin(AdminRegisterDTO dto) {
        super(dto.getName(), dto.getEmail());
        this.phoneNumber = dto.getPhoneNumber();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvents(Event events) {
        this.events.add(events);
    }

    
}
