package com.SD.MHT.repository;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.PatientVisitDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDetailRepository {
    @Autowired
    private MHTDaoImpl mhtDao;

    public String save(PatientVisitDetails patientVisitDetails) {
        // TODO Auto-generated method stub
        System.out.println("Repository");
        String visit_id = mhtDao.saveNewVisitDetails(patientVisitDetails);
        System.out.println("Details save from repository");
        return visit_id;

    }

}
