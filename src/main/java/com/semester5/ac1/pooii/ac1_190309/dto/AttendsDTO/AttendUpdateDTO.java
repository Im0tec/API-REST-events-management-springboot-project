/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto.AttendsDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AttendUpdateDTO {
    
    @NotBlank(message = "Insert a name")
    @Size(min = 3, max = 100, message = "Name requires a minimum of 3 characters and a maximum of 100")
    private String name;

    @NotBlank(message = "Insert an email")
    @Size(min = 3, max = 100, message = "Email requires a minimum of 3 characters and a maximum of 100")
    private String email;

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
}
