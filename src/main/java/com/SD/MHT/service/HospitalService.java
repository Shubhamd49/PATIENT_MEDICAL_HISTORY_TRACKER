package com.SD.MHT.service;

import com.SD.MHT.entity.Hospitals;
import com.SD.MHT.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public void addHospital(Hospitals hospital) {
        hospitalRepository.save(hospital);
    }

    public Object getHospitalById(Long id) {
        Object optionalHospital = hospitalRepository.findById(id);
        return optionalHospital; // Returns null if not found
    }
}
