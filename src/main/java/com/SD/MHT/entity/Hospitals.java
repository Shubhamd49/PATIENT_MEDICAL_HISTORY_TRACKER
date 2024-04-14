package com.SD.MHT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hospital_id;
    private String name;
    private String address;
    private String contact_info;
    private String user_login_id;

    public Hospitals(String name, String address, String contact_info) {
        super();

        this.name = name;
        this.address = address;
        this.contact_info = contact_info;
    }

    public Hospitals(String hospital_id, String name, String address, String contact_info, String user_login_id) {
        super();
        this.hospital_id = hospital_id;
        this.name = name;
        this.address = address;
        this.contact_info = contact_info;
        this.user_login_id = user_login_id;
    }

//    @Override
//    public String toString() {
//        return "Hospitals [hospital_id=" + hospital_id + ", name=" + name + ", address=" + address + ", contact_info="
//                + contact_info + ", user_login_id=" + user_login_id + "]";
//    }

    @Override
    public String toString() {
        return "{\"hospital_id\": \"" + hospital_id + "\""
                +", \"name\": \"" + name + "\""
                + ", \"address\": \"" + address + "\""
                + ", \"contact_info\": \"" + contact_info + "\""
                + ", \"user_login_id\": \"" + user_login_id + "}";
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
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
