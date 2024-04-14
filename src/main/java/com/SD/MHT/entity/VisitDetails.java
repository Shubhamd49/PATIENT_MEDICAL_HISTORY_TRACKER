package com.SD.MHT.entity;

import java.util.List;

public class VisitDetails {

    private String date;
    private String hospital_name;
    private String doctor_name;
    private String issue;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSuggested_tests() {
        return suggested_tests;
    }

    public void setSuggested_tests(String suggested_tests) {
        this.suggested_tests = suggested_tests;
    }

    public VisitDetails(String date, String hospital_name, String doctor_name, String issue, String diagnosis, String suggested_tests) {
        this.date = date;
        this.hospital_name = hospital_name;
        this.doctor_name = doctor_name;
        this.issue = issue;
        this.diagnosis = diagnosis;
        this.suggested_tests = suggested_tests;
    }

    private String diagnosis;
    private String suggested_tests;

    @Override
    public String toString() {


        return "{" +
                "\"date\": \"" + date + "\"" +
                ", \"hospital_name\": \"" + hospital_name + "\"" +
                ", \"doctor_name\": \"" + doctor_name + "\"" +
                ", \"issue\": \"" + issue + "\"" +
                ", \"diagnosis\": \"" + diagnosis + "\"" +
                ", \"suggested_tests\": \"" + suggested_tests + "\"" +

                "}";
    }
}
