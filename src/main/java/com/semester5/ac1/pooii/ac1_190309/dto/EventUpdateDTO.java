package com.semester5.ac1.pooii.ac1_190309.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EventUpdateDTO {

    @NotBlank(message = "Type a name")
    @Size(min = 3, max = 100, message = "Name requires a minimum of 3 characters and a maximum of 100")
    private String name;

    @NotBlank(message = "Type a description")
    @Size(min = 3, max = 100, message = "Description requires a minimum of 3 characters and a maximum of 100")
    private String description;

    @NotBlank(message = "Type an email")
    @Size(min = 3, max = 100, message = "Email requires a minimum of 3 characters and a maximum of 100")
    @Email
    private String email;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
