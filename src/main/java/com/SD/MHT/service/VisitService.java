package com.SD.MHT.service;

import com.SD.MHT.entity.PatientVisitDetails;
import com.SD.MHT.repository.VisitDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    private VisitDetailRepository visitDetailsRepository;


    public String addPatientHospitalVisitData(String patient_id, String hospital_id, String doctor_id, String visit_date,
                                            String issue, String diagnosis, String test_suggested) {
        // TODO Auto-generated method stub
        PatientVisitDetails patientVisitDetails = new PatientVisitDetails(patient_id, hospital_id, doctor_id, visit_date,
                issue, diagnosis, test_suggested);
        System.out.println(patientVisitDetails.toString());
        String visit_id = visitDetailsRepository.save(patientVisitDetails);
        System.out.println(visit_id+"from visit service");
        return visit_id;

    }

}
