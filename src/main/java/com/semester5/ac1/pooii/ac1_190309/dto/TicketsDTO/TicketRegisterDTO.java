/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto.TicketsDTO;

import javax.validation.constraints.NotNull;

import com.semester5.ac1.pooii.ac1_190309.entities.Attend;
import com.semester5.ac1.pooii.ac1_190309.entities.type.TicketType;

public class TicketRegisterDTO {
    
    @NotNull(message = "Insert a ticket type")
    private TicketType type;

    @NotNull(message = "Insert an adminId")
    private Attend attend;

    public TicketType getType() {
        return type;
    }
    public void setType(TicketType type) {
        this.type = type;
    }
    public Attend getAttend() {
        return attend;
    }
    public void setAttend(Attend attend) {
        this.attend = attend;
    }

    
}
