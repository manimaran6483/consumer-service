package com.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consumer.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

	Optional<Consumer> findById(Long consumerid);

	boolean existsById(Long id);
}
