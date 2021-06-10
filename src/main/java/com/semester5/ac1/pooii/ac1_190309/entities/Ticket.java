package com.semester5.ac1.pooii.ac1_190309.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO.TicketRegisterDTO;
import com.semester5.ac1.pooii.ac1_190309.entities.type.TicketType;

@Entity
@Table(name = "TB_TICKET")
public class Ticket implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date;
    private Double price;
    private TicketType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "EVENTID_TICKET")
    private Event eventTicket;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ATTENDID_TICKET")
    private Attend attendTicket;

    public Ticket() {
    }

    public Ticket(Long id, Instant date, Double price) {
        this.id = id;
        this.date = date;
        this.price = price;
    }

    public Ticket(TicketRegisterDTO dto, Double price, Event event){
        this.date = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC);
        this.price = price;
        this.type = dto.getType();
        this.attendTicket = dto.getAttend();
        this.eventTicket = event;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getDate() {
        return date;
    }
    public void setDate(Instant date) {
        this.date = date;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Event getEventTicket() {
        return eventTicket;
    }

    public void setEventTicket(Event eventTicket) {
        this.eventTicket = eventTicket;
    }

    public Attend getAttendTicket() {
        return attendTicket;
    }

    public void setAttendTicket(Attend attendTicket) {
        this.attendTicket = attendTicket;
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
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
