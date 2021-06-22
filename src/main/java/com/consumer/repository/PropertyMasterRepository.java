package com.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.model.PropertyMaster;

@Repository
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster, Long>{

}
