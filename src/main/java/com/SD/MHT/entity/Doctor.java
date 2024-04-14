package com.SD.MHT.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String doctor_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("specialization")
    private String specialization;
    private String user_login_id;
//	public Doctor(String name, String specialization) {
//		super();
//		this.name = name;
//		this.specialization = specialization;
//	}

    @JsonCreator
    public Doctor(@JsonProperty("name") String name, @JsonProperty("specialization") String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public Doctor(String doctor_id, String name, String specialization, String user_login_id) {
        super();
        this.doctor_id = doctor_id;
        this.name = name;
        this.specialization = specialization;
        this.user_login_id = user_login_id;
    }

    public Doctor(String doctor_name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public Doctor() {

    }

    @Override
    public String toString() {
        return "{\"doctor_id\": \"" + doctor_id + "\""
                +", \"name\": \"" + name + "\""
                + ", \"specialization\": \"" + specialization + "\""
                + ", \"user_login_id\": \"" + user_login_id + "}";
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUser_login_id() {
        return user_login_id;
    }

    public void setUser_login_id(String user_login_id) {
        this.user_login_id = user_login_id;
    }

}
