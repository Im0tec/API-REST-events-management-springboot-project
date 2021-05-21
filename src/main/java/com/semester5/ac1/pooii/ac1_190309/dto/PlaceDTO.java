/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto;

import com.semester5.ac1.pooii.ac1_190309.entities.Place;

public class PlaceDTO {
    
    private String name;
    private String address;
    
    public PlaceDTO() {
    }

    public PlaceDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public PlaceDTO(Place place) {
        this.name = place.getName();
        this.address = place.getAddress();
    }

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
