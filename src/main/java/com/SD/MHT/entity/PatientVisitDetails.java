package com.SD.MHT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientVisitDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String visit_id;
    private String patient_id;
    private String hospital_id;
    private String doctor_id;
    private String visit_date;
    private String issue;
    private String diagnosis;
    private String tests_suggested;
//	private String doctor_name;

    public PatientVisitDetails(String visit_id, String patient_id, String hospital_id, String doctor_id, String visit_date,
                               String issue, String diagnosis, String test_suggested) {
        super();
        this.visit_id = visit_id;
        this.patient_id = patient_id;
        this.hospital_id = hospital_id;
        this.doctor_id = doctor_id;
        this.visit_date = visit_date;
        this.issue = issue;
        this.diagnosis = diagnosis;
    }

    public PatientVisitDetails(String patient_id, String hospital_id, String doctor_id, String visit_date,
                               String issue, String diagnosis, String test_suggested) {
        super();
        this.patient_id = patient_id;
        this.hospital_id = hospital_id;
        this.doctor_id = doctor_id;
        this.visit_date = visit_date;
        this.issue = issue;
        this.diagnosis = diagnosis;
        this.tests_suggested=test_suggested;
    }

    public PatientVisitDetails() {

    }

//    @Override
//    public String toString() {
//        return "PatientVisitDetails [visit_id=" + visit_id + ", patient_id=" + patient_id + ", hospital_id="
//                + hospital_id + ", doctor_id=" + doctor_id + ", visit_date=" + visit_date + ", issue=" + issue
//                + ", diagnosis=" + diagnosis + "]";
//    }
    @Override
    public String toString() {
        return "{\"visit_id\": \"" + visit_id + "\""
                +", \"patient_id\": \"" + patient_id + "\""
                + ", \"hospital_id\": \"" + hospital_id + "\""
                + ", \"doctor_id\": \"" + doctor_id + "\""
                + ", \"visit_date\": \"" + visit_date + "\""
                + ", \"issue\": \"" + issue + "\""
                + ", \"diagnosis\": \"" + diagnosis + "\""
                + ", \"test_suggested\": \"" + tests_suggested + "}";
    }
    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(String visit_date) {
        this.visit_date = visit_date;
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

    public String getTests_suggested() {
        return tests_suggested;
    }

    public void setTests_suggested(String tests_suggested) {
        this.tests_suggested = tests_suggested;
    }


}
