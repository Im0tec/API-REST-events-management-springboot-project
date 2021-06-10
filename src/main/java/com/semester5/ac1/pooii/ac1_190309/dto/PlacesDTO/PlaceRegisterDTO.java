/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto.PlacesDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PlaceRegisterDTO {
    
    @NotBlank(message = "Insert a name")
    @Size(min = 3, max = 100, message = "Name requires a minimum of 3 characters and a maximum of 100")
    private String name;

    @NotBlank(message = "Insert an address")
    @Size(min = 3, max = 100, message = "Address requires a minimum of 3 characters and a maximum of 100")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
