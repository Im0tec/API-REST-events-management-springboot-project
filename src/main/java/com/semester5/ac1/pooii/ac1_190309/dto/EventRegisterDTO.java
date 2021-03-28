/*
 * NOME: Eduardo Campos Gonçalves - 190309
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EventRegisterDTO {

    @NotBlank(message = "Type a name")
    @Size(min = 3, max = 100, message = "Name requires a minimum of 3 characters and a maximum of 100")
    private String name;

    @NotBlank(message = "Type a description")
    @Size(min = 3, max = 100, message = "Description requires a minimum of 3 characters and a maximum of 100")
    private String description;

    @NotBlank(message = "Type a place")
    @Size(min = 3, max = 100, message = "Place requires a minimum of 3 characters and a maximum of 100")
    private String place;

    @NotEmpty(message = "Start date can't be empty")
    private String start_date;

    @NotEmpty(message = "End date can't be empty")
    private String end_date;

    @NotEmpty(message = "Start time can't be empty")
    private String start_time;

    @NotEmpty(message = "End date can't be empty")
    private String end_time;

    @NotBlank(message = "Type an email")
    @Size(min = 3, max = 100, message = "Email requires a minimum of 3 characters and a maximum of 100")
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
}
