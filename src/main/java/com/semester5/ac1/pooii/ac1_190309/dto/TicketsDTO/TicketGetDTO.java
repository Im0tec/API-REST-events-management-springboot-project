package com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO;

import com.semester5.ac1.pooii.ac1_190309.entities.Ticket;
import com.semester5.ac1.pooii.ac1_190309.entities.type.TicketType;

public class TicketGetDTO {
    
    private TicketType type;
    private String attendName;
    
    public TicketGetDTO() {
    }

    public TicketGetDTO(TicketType type, String attendName) {
        this.type = type;
        this.attendName = attendName;
    }
    
    public TicketGetDTO(Ticket ticket) {
        this.type = ticket.getType();
        this.attendName = ticket.getAttendTicket().getName();
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String getAttendName() {
        return attendName;
    }

    public void setAttendName(String attendName) {
        this.attendName = attendName;
    }

    
}
