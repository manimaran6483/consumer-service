package com.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consumer.model.BusinessMaster;
@Repository
public interface BusinessMasterRepository extends JpaRepository<BusinessMaster, Long>{

}
