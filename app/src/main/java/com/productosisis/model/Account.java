package com.productosisis.model;

import java.util.Date;

public class Account {
    private String first_name;
    private String last_name;
    private int document_id;
    private Date birthdate;
    private String email;
    private String password;
    private String address;

    public Account(String first_name, String last_name, int document_id, Date birthdate, String email, String password, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.document_id = document_id;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Account() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
