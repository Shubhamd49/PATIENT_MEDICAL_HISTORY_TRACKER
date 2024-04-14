package com.SD.MHT.repository;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.Labs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LabRepository {

    @Autowired
    private MHTDaoImpl mhtDao;

    public void save(Labs lab) {
        // TODO Auto-generated method stub
        mhtDao.saveNewLabDetails(lab);
    }

    public Object findById(Long id) {
        // TODO Auto-generated method stub
        return mhtDao.getLabDetailsById(id);
    }

    public Object findByTestResultId(long l) {
        return mhtDao.getTestResultDetailsById(l);
    }
}

//@Repository
//public interface LabRepository extends JpaRepository<Labs, Long> {
//}
