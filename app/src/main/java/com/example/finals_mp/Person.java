package com.example.finals_mp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "personName")
    private String name;

    @ColumnInfo(name = "personAmount")
    private String amount;

    @ColumnInfo(name = "personAddress")
    private String address;


    @ColumnInfo(name ="personEmail")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
