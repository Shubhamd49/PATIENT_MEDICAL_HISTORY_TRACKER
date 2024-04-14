package com.SD.MHT.entity;

import java.util.List;

public class PatientData {

    private String patient_id;
    private String name;
    private String date_of_birth;
    private String gender;
    private String contact_no;
    private String mail_id;

    private List<VisitDetails> visit_details;

    @Override
    public String toString() {



        return "{" +
                "\"patient_id\": \"" + patient_id + "\"" +
                ", \"name\": \"" + name + "\"" +
                ", \"date_of_birth\": \"" + date_of_birth + "\"" +
                ", \"gender\": \"" + gender + "\"" +
                ", \"contact_no\": \"" + contact_no + "\"" +
                ", \"mail_id\": \"" + mail_id + "\"" +
                ", \"visit_details\": " + visit_details +
                ", \"med_test_results\": " + med_test_results + "}" ;


    }

    public PatientData() {

    }

    public PatientData(String patient_id, String name, String date_of_birth, String gender, String contact_no, String mail_id, List<VisitDetails> visit_details, List<MedTestResultData> med_test_results) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.contact_no = contact_no;
        this.mail_id = mail_id;
        this.visit_details = visit_details;
        this.med_test_results = med_test_results;
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

    public List<VisitDetails> getVisit_details() {
        return visit_details;
    }

    public void setVisit_details(List<VisitDetails> visit_details) {
        this.visit_details = visit_details;
    }

    public List<MedTestResultData> getMed_test_results() {
        return med_test_results;
    }

    public void setMed_test_results(List<MedTestResultData> med_test_results) {
        this.med_test_results = med_test_results;
    }

    private List<MedTestResultData> med_test_results;
}
