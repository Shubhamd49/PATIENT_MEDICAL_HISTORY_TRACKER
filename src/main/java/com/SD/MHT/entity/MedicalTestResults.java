package com.SD.MHT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class MedicalTestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testresult_id;
    private int visit_id;
    private int lab_id;
    private int patient_id;

    private Date test_date;
    private int report_id;
    private String result;

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public MedicalTestResults(int testresult_id, int visit_id, int test_id, int lab_id, Date test_date, int patient_id, int report_id,
                              String result) {
        super();
        this.testresult_id = testresult_id;
        this.visit_id = visit_id;

        this.lab_id = lab_id;
        this.test_date = test_date;
        this.report_id = report_id;
        this.result = result;
        this.patient_id = patient_id;
    }

    public MedicalTestResults() {

    }

//    @Override
//    public String toString() {
//        return "MedicalTestResults [testresult_id=" + testresult_id + ", visit_id=" + visit_id + ", lab_id=" + lab_id
//                + ", test_date=" + test_date + ", report_id=" + report_id + ", result=" + result + "]";
//    }

    @Override
    public String toString() {
        return "{\"testresult_id\": \"" + testresult_id + "\""
                +", \"visit_id\": \"" + visit_id + "\""
                + ", \"lab_id\": \"" + lab_id + "\""
                + ", \"test_date\": \"" + test_date + "\""
                + ", \"report_id\": \"" + report_id + "\""
                + ", \"patient_id\": \"" + patient_id + "\""
                + ", \"result\": \"" + result + "}";
    }

    public int getTestresult_id() {
        return testresult_id;
    }

    public void setTestresult_id(int testresult_id) {
        this.testresult_id = testresult_id;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public int getLab_id() {
        return lab_id;
    }

    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public Date getTest_date() {
        return test_date;
    }

    public void setTest_date(Date test_date) {
        this.test_date = test_date;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
