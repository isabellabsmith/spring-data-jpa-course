package com.isabellabs.hibernateinheritance.hibernateinheritance.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment {
    private String checknumber;

    public String getCheckNumber() {
        return checknumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checknumber = checkNumber;
    }
}
