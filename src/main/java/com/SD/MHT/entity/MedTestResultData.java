package com.SD.MHT.entity;

public class MedTestResultData {
    private String test_date;

    public String gettest_status() {
        return test_status;
    }

    public void setTEST_STATUS(String test_status) {
        this.test_status = test_status;
    }

    private String test_status;
    private String testresult_id;
    private String hospital_name;
    private String patient_id;
    private String visit_id;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    @Override
    public String toString() {


        return "{" +
                "\"test_status\": \"" + test_status + "\"" +
                "\"test_date\": \"" + test_date + "\"" +
                ", \"visit_id\": \"" + visit_id + "\"" +
                ", \"patient_id\": \"" + patient_id + "\"" +
                ", \"hospital_name\": \"" + hospital_name + "\"" +
                ", \"doctor_name\": \"" + doctor_name + "\"" +
                ", \"lab_name\": \"" + lab__name + "\"" +
                ", \"report_id\": \"" + report_id + "\"" +
                ", \"result\": \"" + result + "\"" +

                "}";
    }

    public MedTestResultData(String test_status, String test_date, String visit_id, String patient_id, String hospital_name, String doctor_name, String lab__name, String report_id, String result) {
        this.test_status = test_status;
        this.test_date = test_date;
        this.visit_id = visit_id;
        this.hospital_name = hospital_name;
        this.doctor_name = doctor_name;
        this.lab__name = lab__name;
        this.report_id = report_id;
        this.result = result;
        this.patient_id = patient_id;
    }

    public String getTest_date() {
        return test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
    }

    private String doctor_name;
    private String lab__name;
    private String report_id;
    private String result;

    public String getPatient_name() {
        return patient_id;
    }

    public void setPatient_name(String patient_id) {
        this.patient_id = patient_id;
    }
}
