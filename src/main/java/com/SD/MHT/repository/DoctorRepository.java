package com.SD.MHT.repository;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepository {


    @Autowired
    private MHTDaoImpl mhtDao;

    public void save(Doctor doctor) {
        // TODO Auto-generated method stub
        mhtDao.saveNewDoctorDetails(doctor);

    }

    public Object findById(Long id) {
        System.out.println("repository");
        // TODO Auto-generated method stub
        return mhtDao.getDoctorDetailsById(id);
    }

}


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//}
