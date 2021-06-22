package com.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

	Business findByConsumerId(Long consumerId);

	boolean existsById(Long id);

	boolean existsByConsumerId(Long consumerId);
}