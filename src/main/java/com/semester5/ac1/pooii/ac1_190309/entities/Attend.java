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

import com.semester5.ac1.pooii.ac1_190309.dto.AttendsDTO.AttendRegisterDTO;

@Entity
@Table(name = "TB_ATTEND")
@PrimaryKeyJoinColumn(name = "BASEUSER_ID")
public class Attend extends BaseUser {
    
    private Double balance;

    @OneToMany(mappedBy = "attendTicket")
    private List<Ticket> tickets = new ArrayList<>();

    public Attend() {
    }

    public Attend(Double balance) {
        this.balance = balance;
    }

    public Attend(String name, String email, Double balance) {
        super(name, email);
        this.balance = balance;
    }

    public Attend(AttendRegisterDTO attend) {
        super(attend.getName(), attend.getEmail());
        this.balance = attend.getBalance();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket tickets) {
        this.tickets.add(tickets);
    }

    public Boolean canBuyTicket(Double ticketPrice) {
        Double balance = getBalance();

        balance = balance - ticketPrice;

        if(balance < 0) return false;
        else{
            this.balance = balance;
            return true;
        } 
    }
    
}
