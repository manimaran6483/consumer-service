package com.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.model.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	Property findByConsumerId(Long consumerid);

	boolean existsById(Long propertyId);
}
