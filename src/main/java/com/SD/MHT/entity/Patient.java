package com.SD.MHT.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String patient_id;
    private String name;
    private String date_of_birth;
    private String gender;
    private String contact_no;
    private String mail_id;
    private String user_login_id;

    public Patient(String name, String date_of_birth, String gender, String contact_no, String mail_id) {
        super();
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.contact_no = contact_no;
        this.mail_id = mail_id;
    }

    public Patient(String patient_id, String name, String date_of_birth, String gender, String contact_no,
                   String mail_id, String user_login_id) {
        super();
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.contact_no = contact_no;
        this.mail_id = mail_id;
        this.user_login_id = user_login_id;
    }

    public Patient(String patientId, String name, String dateOfBirth, String gender, String contactNo, String mailId) {
        super();
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.contact_no = contact_no;
        this.mail_id = mail_id;
    }

//    @Override
//    public String toString() {
//        return "Patient [patient_id=" + patient_id + ", name=" + name + ", date_of_birth=" + date_of_birth + ", gender="
//                + gender + ", contact_no=" + contact_no + ", mail_id=" + mail_id + ", user_login_id=" + user_login_id
//                + "]";
//    }
    @Override
    public String toString() {
        return "{\"patient_id\": \"" + patient_id + "\""
                +", \"name\": \"" + name + "\""
                + ", \"date_of_birth\": \"" + date_of_birth + "\""
                + ", \"gender\": \"" + gender + "\""
                + ", \"contact_no\": \"" + contact_no + "\""
                + ", \"mail_id\": \"" + mail_id + "\""
                + ", \"user_login_id\": \"" + user_login_id + "}";
    }
    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getUser_login_id() {
        return user_login_id;
    }

    public void setUser_login_id(String user_login_id) {
        this.user_login_id = user_login_id;
    }

    // Getters and setters
}