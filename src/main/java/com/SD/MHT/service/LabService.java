package com.SD.MHT.service;

import com.SD.MHT.entity.Labs;
import com.SD.MHT.repository.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabService {

    @Autowired
    private LabRepository labRepository;

    public void addLab(Labs lab) {
        labRepository.save(lab);
    }

    public Object getLabById(Long id) {
        Object optionalLab = labRepository.findById(id);
        return optionalLab; // Returns null if not found
    }

    public Object getTestResultId(long l) {
        Object optionalTestResultId = labRepository.findByTestResultId(l);
        return optionalTestResultId;
    }
}