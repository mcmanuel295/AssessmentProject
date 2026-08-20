package com.mcmanuel.AssesmentApplication.domain.box.repository;

import com.mcmanuel.AssesmentApplication.domain.box.entity.BoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BoxRepository extends JpaRepository<BoxEntity,Integer> {

    Optional<BoxEntity> findByTxRef(String txRef);
}