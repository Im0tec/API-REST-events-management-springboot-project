/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.semester5.ac1.pooii.ac1_190309.dto.EventRegisterDTO;

@Entity
@Table(name="TB_EVENT")
public class Event implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String name;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String email;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Double priceTicket;

    private String place;

    @ManyToOne
    private Admin admin;
    
    /*@ManyToMany(mappedBy = "events")
    private List<Place> places = new ArrayList<>();*/
    
    public Event() {
       
    }

    public Event(EventRegisterDTO dto) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.start_date = LocalDate.parse(dto.getStart_date(), formatter);
        this.end_date = LocalDate.parse(dto.getEnd_date(), formatter);
        this.start_time = LocalTime.parse(dto.getStart_time());
        this.end_time = LocalTime.parse(dto.getEnd_time());
        this.email = dto.getEmail();
        this.place = dto.getPlace();
    }

    

    public Event(Long id, String name, String description, LocalDate start_date, LocalDate end_date,
            LocalTime start_time, LocalTime end_time, String email, Long amountFreeTickets, Long amountPayedTickets,
            Double priceTicket, Admin admin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.email = email;
        this.amountFreeTickets = amountFreeTickets;
        this.amountPayedTickets = amountPayedTickets;
        this.priceTicket = priceTicket;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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

    public LocalDate getStart_date() {
        return start_date;
    }
    
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    
    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    public LocalTime getStart_time() {
        return start_time;
    }
    
    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }
   
    public LocalTime getEnd_time() {
        return end_time;
    }
    
    public void setEnd_time(LocalTime end_time) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
