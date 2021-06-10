package com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO;

import java.util.ArrayList;
import java.util.List;

public class TicketDTO {
    
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long amountFreeTicketsSold;
    private Long amountPayedTicketsSold;

    private List<TicketGetDTO> tickets = new ArrayList<>();

    public TicketDTO() {
    }

    public TicketDTO(Long amountFreeTickets, Long amountPayedTickets, Long amountFreeTicketsSold,
            Long amountPayedTicketsSold, List<TicketGetDTO> tickets) {
        this.amountFreeTickets = amountFreeTickets;
        this.amountPayedTickets = amountPayedTickets;
        this.amountFreeTicketsSold = amountFreeTicketsSold;
        this.amountPayedTicketsSold = amountPayedTicketsSold;
        this.tickets = tickets;
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

    public Long getAmountFreeTicketsSold() {
        return amountFreeTicketsSold;
    }

    public void setAmountFreeTicketsSold(Long amountFreeTicketsSold) {
        this.amountFreeTicketsSold = amountFreeTicketsSold;
    }

    public Long getAmountPayedTicketsSold() {
        return amountPayedTicketsSold;
    }

    public void setAmountPayedTicketsSold(Long amountPayedTicketsSold) {
        this.amountPayedTicketsSold = amountPayedTicketsSold;
    }

    public List<TicketGetDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketGetDTO> tickets) {
        this.tickets = tickets;
    }

}
