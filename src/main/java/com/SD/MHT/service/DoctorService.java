package com.SD.MHT.service;

import com.SD.MHT.entity.Doctor;
import com.SD.MHT.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Object getDoctorById(Long id) {
        System.out.println("service");
        Object optionalDoctor = doctorRepository.findById(id);
        System.out.println(optionalDoctor);
        return optionalDoctor; // Returns null if not found
    }
}