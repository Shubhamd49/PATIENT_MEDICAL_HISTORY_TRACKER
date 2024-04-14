package com.SD.MHT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Labs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String lab_id;
    private String name;
    private String address;
    private String contact_info;
    private String user_login_id;

    public Labs(String name, String address, String contact_info) {
        super();
        this.name = name;
        this.address = address;
        this.contact_info = contact_info;
    }

    public Labs(String lab_id, String name, String address, String contact_info, String user_login_id) {
        super();
        this.lab_id = lab_id;
        this.name = name;
        this.address = address;
        this.contact_info = contact_info;
        this.user_login_id = user_login_id;
    }

//    @Override
//    public String toString() {
//        return "Labs [lab_id=" + lab_id + ", name=" + name + ", address=" + address + ", contact_info=" + contact_info
//                + ", user_login_id=" + user_login_id + "]";
//    }

    @Override
    public String toString() {
        return "{\"lab_id\": \"" + lab_id + "\""
                +", \"name\": \"" + name + "\""
                + ", \"address\": \"" + address + "\""
                + ", \"contact_info\": \"" + contact_info + "\""
                + ", \"user_login_id\": \"" + user_login_id + "}";
    }

    public String getLab_id() {
        return lab_id;
    }

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id;
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

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getUser_login_id() {
        return user_login_id;
    }

    public void setUser_login_id(String user_login_id) {
        this.user_login_id = user_login_id;
    }

}
