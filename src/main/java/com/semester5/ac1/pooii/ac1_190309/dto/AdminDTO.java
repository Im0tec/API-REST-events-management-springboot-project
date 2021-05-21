package com.semester5.ac1.pooii.ac1_190309.dto;

import com.semester5.ac1.pooii.ac1_190309.entities.Admin;

public class AdminDTO {
    
    private String name;
    private String email;
    private String phoneNumber;

    public AdminDTO() {
    }

    public AdminDTO(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public AdminDTO(Admin admin) {
        this.name = admin.getName();
        this.email = admin.getEmail();
        this.phoneNumber = admin.getPhoneNumber();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
