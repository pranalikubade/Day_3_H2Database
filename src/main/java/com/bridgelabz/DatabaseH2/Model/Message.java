package com.bridgelabz.DatabaseH2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity                 //Table Creation
@Table(name = "TableInfo")
public class Message {
    @Id
    @GeneratedValue      //generate unique value automatically
    private  int id;
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
