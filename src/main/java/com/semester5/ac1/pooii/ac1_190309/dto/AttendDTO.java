/*
 * DUPLA:
 *  
 * Eduardo Campos Gonçalves - 190309
 * Johanna Bernecker - 190737
 * 
 * TURMA: CP108LPIN2
 */
package com.semester5.ac1.pooii.ac1_190309.dto;

import com.semester5.ac1.pooii.ac1_190309.entities.Attend;

public class AttendDTO {
    
    private String name;
    private String email;
    private Double balance;
    
    public AttendDTO() {
    }

    public AttendDTO(String name, String email, Double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public AttendDTO(Attend attend) {
        this.name = attend.getName();
        this.email = attend.getEmail();
        this.balance =  attend.getBalance();
    }

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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
