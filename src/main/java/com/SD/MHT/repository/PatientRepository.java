package com.SD.MHT.repository;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.Patient;
import com.SD.MHT.entity.PatientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class PatientRepository {

    @Autowired
    private MHTDaoImpl mhtDao;

    public void save(Patient patient) {
        // TODO Auto-generated method stub
        mhtDao.saveNewPatientDetails(patient);

    }

    public Object findById(Long id) {
        // TODO Auto-generated method stub
        return mhtDao.getPatientDetailsById(id);
    }

    public Object getPatientDataById(Long id){
        return mhtDao.getPatientVisitData(id);
    }

    public void saveMedTestData(String visit_id, String suggestedTest, String patientId, String s) {
        mhtDao.saveNewMedTestData(visit_id, suggestedTest, patientId, s);
        System.out.println("Med Test add Reporsitory");
    }
}

//@Repository
//public interface PatientRepository extends JpaRepository<Patient, Long> {
//}