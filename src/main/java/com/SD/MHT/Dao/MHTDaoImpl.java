package com.SD.MHT.Dao;

import com.SD.MHT.entity.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MHTDaoImpl {

    private final JdbcTemplate jdbcTemplate;
    private String GET_MED_TEST_RESULT_SQL = "SELECT mht.test_status as 'TEST_STATUS', mht.test_date as 'TEST_DATE', labs.name as 'LAB_NAME', mht.report_id as 'REPORT_ID', mht.test_name as 'TEST_NAME', visit.visit_id as 'VISIT_ID', dr.name as 'DOCTOR_NAME', hp.name as 'HOSPITAL_NAME', mht.result as 'TEST_RESULT' from sdmht_patient_medical_testresults mht JOIN sdmht_lab_details as labs ON mht.lab_id=labs.lab_id join sdmht_patientvisit_details visit on mht.visit_id=visit.visit_id join sdmht_doctor_details dr on visit.doctor_id=dr.doctor_id join sdmht_hospital_details hp on visit.hospital_id=hp.hospital_id where mht.patient_id=?";
    private String GET_PATIENT_VISIT_DATA = "select visit.visit_date as 'VISIT_DATE', hp.name as 'HOSPITAL_NAME', dr.name as 'DOCTOR_NAME', visit.issue as 'SYMPTOMS', visit.diagnosis as 'DIAGNOSIS', visit.suggested_tests as 'TEST_SUGGESTION' from sdmht_patientvisit_details visit join sdmht_doctor_details dr on visit.doctor_id=dr.doctor_id join sdmht_hospital_details hp on visit.HOSPITAL_ID=hp.HOSPITAL_ID where PATIENT_ID=?";

    public MHTDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveNewDoctorDetails(Doctor doctor) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO sdmht_doctor_details (NAME, SPECIALIZATION) VALUES (?, ?)";
        System.out.println("Adding new doctor");
        Object[] inputParams = {doctor.getName(), doctor.getSpecialization()};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, inputParams, sqlTypes);

    }

    public void saveNewHospitalDetails(Hospitals hospital) {
        String sql = "INSERT INTO sdmht_hospital_details (NAME, ADDRESS, CONTACT_INFO) VALUES (?, ?, ?)";
        Object[] inputParams = {hospital.getName(), hospital.getAddress(), hospital.getContact_info()};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, inputParams, sqlTypes);
    }

    public void saveNewLabDetails(Labs lab) {
        String sql = "INSERT INTO sdmht_lab_details (NAME, ADDRESS, CONTACT_INFO) VALUES (?, ?, ?)";
        Object[] inputParams = {lab.getName(), lab.getAddress(), lab.getContact_info()};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, inputParams, sqlTypes);
    }

    public void saveNewPatientDetails(Patient patient) {
        String sql = "INSERT INTO sdmht_patient_details (NAME, DATE_OF_BIRTH, GENDER, CONTACT_NO, MAIL_ID) VALUES (?, ?, ?, ?, ?)";
        Object[] inputParams = {patient.getName(), patient.getDate_of_birth(), patient.getGender(), patient.getContact_no(), patient.getMail_id()};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, inputParams, sqlTypes);
    }

    public Object getDoctorDetailsById(Long id) {
        String sql = "SELECT DOCTOR_ID, NAME, SPECIALIZATION, USER_LOGIN_ID FROM sdmht_doctor_details WHERE DOCTOR_ID=?";
        Object[] inputParams = {id};
        int[] sqlTypes = {Types.BIGINT};

        try {
            Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, inputParams, sqlTypes);
            if (resultMap.size() > 0) {
                Doctor doctor = new Doctor(
                        resultMap.get("DOCTOR_ID") == null ? "NULL" : resultMap.get("DOCTOR_ID").toString(),
                        resultMap.get("NAME").toString(),
                        resultMap.get("SPECIALIZATION").toString(),
                        resultMap.get("USER_LOGIN_ID") == null ? "NULL" : resultMap.get("USER_LOGIN_ID").toString()
                );
                return doctor;
            } else {
                return "No Data Found";
            }
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }


    public Object getHospitalDetailsById(Long id) {
        String sql = "SELECT HOSPITAL_ID, NAME, ADDRESS, CONTACT_INFO, USER_LOGIN_ID FROM sdmht_hospital_details WHERE HOSPITAL_ID=?";
        Object[] inputParams = {id};
        int[] sqlTypes = {Types.BIGINT};

        try {
            Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, inputParams, sqlTypes);
            if (resultMap.size() > 0) {
                Hospitals hospital = new Hospitals(
                        resultMap.get("HOSPITAL_ID").toString(),
                        resultMap.get("NAME").toString(),
                        resultMap.get("ADDRESS").toString(),
                        resultMap.get("CONTACT_INFO").toString(),
                        resultMap.get("USER_LOGIN_ID") == null ? "NULL" : resultMap.get("USER_LOGIN_ID").toString()
                );
                return hospital;
            } else {
                return "No Data Found";
            }
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }

    public Object getLabDetailsById(Long id) {
        String sql = "SELECT LAB_ID, NAME, ADDRESS, CONTACT_INFO, USER_LOGIN_ID FROM sdmht_lab_details WHERE LAB_ID=?";
        Object[] inputParams = {id};
        int[] sqlTypes = {Types.BIGINT};

        try {
            Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, inputParams, sqlTypes);
            if (resultMap.size() > 0) {
                Labs lab = new Labs(
                        resultMap.get("LAB_ID").toString(),
                        resultMap.get("NAME").toString(),
                        resultMap.get("ADDRESS").toString(),
                        resultMap.get("CONTACT_INFO").toString(),
                        resultMap.get("USER_LOGIN_ID") == null ? "NULL" : resultMap.get("USER_LOGIN_ID").toString()
                );
                return lab;
            } else {
                return "No Data Found";
            }
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }

    public Object getPatientDetailsById(Long id) {
        String sql = "SELECT PATIENT_ID, NAME, DATE_OF_BIRTH, GENDER, CONTACT_NO, MAIL_ID, USER_LOGIN_ID FROM sdmht_patient_details WHERE PATIENT_ID=?";
        Object[] inputParams = {id};
        int[] sqlTypes = {Types.BIGINT};

        try {
            Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, inputParams, sqlTypes);
            if (resultMap.size() > 0) {
                Patient patient = new Patient(
                        resultMap.get("PATIENT_ID").toString(),
                        resultMap.get("NAME").toString(),
                        resultMap.get("DATE_OF_BIRTH").toString(),
                        resultMap.get("GENDER").toString(),
                        resultMap.get("CONTACT_NO").toString(),
                        resultMap.get("MAIL_ID").toString(),
                        resultMap.get("USER_LOGIN_ID") == null ? "NULL" : resultMap.get("USER_LOGIN_ID").toString()

                );
                return patient;
            } else {
                return "No Data Found";
            }
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }

    public String saveNewVisitDetails(PatientVisitDetails patientVisitDetails) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO sdmht_patientvisit_details (PATIENT_ID, HOSPITAL_ID, DOCTOR_ID, VISIT_DATE, ISSUE, DIAGNOSIS, SUGGESTED_TESTS) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] inputParams = {
                patientVisitDetails.getPatient_id(),
                patientVisitDetails.getHospital_id(),
                patientVisitDetails.getDoctor_id(),
                patientVisitDetails.getVisit_date(),
                patientVisitDetails.getIssue(),
                patientVisitDetails.getDiagnosis(),
                patientVisitDetails.getTests_suggested()
        };
        int[] sqlTypes = {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };
        jdbcTemplate.update(sql, inputParams, sqlTypes);
        System.out.println("SQL executed");
        return getMaxVisitId();
    }

    public Object getPatientVisitData(Long id) {
        Object[] inputParams = {id};
        int[] sqlTypes = {Types.BIGINT};
        List<MedTestResultData> medTestResultDataList = new ArrayList<>();
        ;
        PatientData patientData = new PatientData();
        List<VisitDetails> visitDetailsList = new ArrayList<>();
        List<Map<String, Object>> resultMapList;
        try {
            resultMapList = jdbcTemplate.queryForList(GET_MED_TEST_RESULT_SQL, inputParams, sqlTypes);
            for (Map<String, Object> resultMap : resultMapList) {
                MedTestResultData medTestResultData = new MedTestResultData(
                        resultMap.get("TEST_STATUS") == null ? "NULL" : resultMap.get("TEST_STATUS").toString(),
                        resultMap.get("TEST_DATE") == null ? "NULL" : resultMap.get("TEST_DATE").toString(),
                        resultMap.get("VISIT_ID").toString() == null ? "NULL" : resultMap.get("VISIT_ID").toString(),
                        String.valueOf(id),
                        resultMap.get("HOSPITAL_NAME").toString() == null ? "NULL" : resultMap.get("HOSPITAL_NAME").toString(),
                        resultMap.get("DOCTOR_NAME").toString() == null ? "NULL" : resultMap.get("DOCTOR_NAME").toString(),
                        resultMap.get("LAB_NAME").toString() == null ? "NULL" : resultMap.get("LAB_NAME").toString(),
                        resultMap.get("REPORT_ID").toString() == null ? "NULL" : resultMap.get("REPORT_ID").toString(),
                        resultMap.get("TEST_RESULT") == null ? "NULL" : resultMap.get("TEST_RESULT").toString()
                );

                medTestResultDataList.add(medTestResultData);
            }


            resultMapList = jdbcTemplate.queryForList(GET_PATIENT_VISIT_DATA, inputParams, sqlTypes);
            for (Map<String, Object> resultMap : resultMapList) {
                VisitDetails visitDetails = new VisitDetails(
                        resultMap.get("VISIT_DATE") == null ? "NULL" : resultMap.get("VISIT_DATE").toString(),
                        resultMap.get("HOSPITAL_NAME").toString() == null ? "NULL" : resultMap.get("HOSPITAL_NAME").toString(),
                        resultMap.get("DOCTOR_NAME").toString() == null ? "NULL" : resultMap.get("DOCTOR_NAME").toString(),
                        resultMap.get("SYMPTOMS").toString() == null ? "NULL" : resultMap.get("SYMPTOMS").toString(),
                        resultMap.get("DIAGNOSIS").toString() == null ? "NULL" : resultMap.get("DIAGNOSIS").toString(),
                        resultMap.get("TEST_SUGGESTION") == null ? "NULL" : resultMap.get("TEST_SUGGESTION").toString()
                );
                visitDetailsList.add(visitDetails);
            }

            patientData.setPatient_id(String.valueOf(id));
            Patient patient = (Patient) getPatientDetailsById(id);
            patientData.setContact_no(patient.getContact_no());
            patientData.setName(patient.getName());
            patientData.setGender(patient.getGender());
            patientData.setMail_id(patient.getMail_id());
            patientData.setDate_of_birth(patient.getDate_of_birth());
            patientData.setMed_test_results(medTestResultDataList);
            patientData.setVisit_details(visitDetailsList);
            return patientData;
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }


    public void saveNewMedTestData(String visit_id, String suggestedTest, String patientId, String s) {
        String sql = "INSERT INTO sdmht_patient_medical_testresults (VISIT_ID, TEST_NAME, PATIENT_ID, TEST_STATUS) VALUES (?, ?, ?,?)";
        Object[] inputParams = {visit_id, suggestedTest, patientId, s};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,};
        jdbcTemplate.update(sql, inputParams, sqlTypes);
        System.out.println("Med Test add sql executed");
    }

    public String getMaxVisitId() {
        String sql = "select max(visit_id) as VISIT_ID from sdmht_patientvisit_details";
        Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql);
        String maxVisitId = null;
        if (resultMap.size() > 0) {
            maxVisitId = resultMap.get("VISIT_ID").toString();
        }
        return maxVisitId;
    }

    public void updateMedTestDetailsByLab(String lab_id, String report_id, String result, String test_status, String testresult_id) {
        String sql = "UPDATE sdmht_patient_medical_testresults set LAB_ID=?, TEST_DATE=sysdate(), report_id=?, result=? , test_status=? where TESTRESULT_ID=?";

        Object[] inputParams = {lab_id, report_id, result, test_status, testresult_id};
        int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update(sql, inputParams, sqlTypes);
    }

    public Object getTestResultDetailsById(long l) {
        String sql = "select TESTRESULT_ID from sdmht_patient_medical_testresults where TESTRESULT_ID=?";
        Object[] inputParams = {l};
        int[] sqlTypes = {Types.BIGINT};

        try {
            Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, inputParams, sqlTypes);
            if (resultMap.size() > 0) {
                String test_result_id = resultMap.get("TESTRESULT_ID").toString();

                return test_result_id;
            } else {
                return "No Data Found";
            }
        } catch (EmptyResultDataAccessException ex) {
            return "No Data Found";
        }
    }
}
