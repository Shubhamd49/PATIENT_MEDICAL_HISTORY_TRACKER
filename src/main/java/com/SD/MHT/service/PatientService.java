package com.SD.MHT.service;

import com.SD.MHT.entity.Patient;
import com.SD.MHT.entity.PatientData;
import com.SD.MHT.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Object getPatientById(Long id) {
        Object optionalPatient = patientRepository.findById(id);
        return optionalPatient; // Returns null if not found
    }

    public Object getHistory(Long id){
        Object optionalPatient = patientRepository.getPatientDataById(id);
        return optionalPatient;

    }

    public void insertTestDetailsInDB(String visit_id, String suggestedTest, String patientId, String s) {

        patientRepository.saveMedTestData(visit_id, suggestedTest, patientId, s);
        System.out.println("Med Test add Service");
    }
}
