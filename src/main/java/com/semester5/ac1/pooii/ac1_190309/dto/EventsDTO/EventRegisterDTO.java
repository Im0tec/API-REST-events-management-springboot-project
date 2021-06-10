/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto.EventsDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.semester5.ac1.pooii.ac1_190309.entities.Admin;

public class EventRegisterDTO {

    @NotBlank(message = "Insert a name")
    @Size(min = 3, max = 100, message = "Name requires a minimum of 3 characters and a maximum of 100")
    private String name;

    @NotBlank(message = "Insert a description")
    @Size(min = 3, max = 100, message = "Description requires a minimum of 3 characters and a maximum of 100")
    private String description;

    @NotEmpty(message = "Start date can't be empty")
    private String start_date;

    @NotEmpty(message = "End date can't be empty")
    private String end_date;

    @NotEmpty(message = "Start time can't be empty")
    private String start_time;

    @NotEmpty(message = "End date can't be empty")
    private String end_time;

    @NotBlank(message = "Insert an email")
    @Size(min = 3, max = 100, message = "Email requires a minimum of 3 characters and a maximum of 100")
    private String email;

    @NotNull(message = "Insert amountFreeTickets")
    private Long amountFreeTickets;

    @NotNull(message = "Insert amountPayedTickets")
    private Long amountPayedTickets;

    @NotNull(message = "Insert ticket price")
    private Double priceTicket;

    @NotNull(message = "Insert an adminId")
    private Admin admin;

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

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }

    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
   
}
