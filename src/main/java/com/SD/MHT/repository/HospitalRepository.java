package com.SD.MHT.repository;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.Hospitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {

    @Autowired
    private MHTDaoImpl mhtDao;

    public void save(Hospitals hospital) {
        // TODO Auto-generated method stub
        mhtDao.saveNewHospitalDetails(hospital);

    }

    public Object findById(Long id) {
        // TODO Auto-generated method stub
        return mhtDao.getHospitalDetailsById(id);
    }

}

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface HospitalRepository extends JpaRepository<Hospitals, Long> {
//}
