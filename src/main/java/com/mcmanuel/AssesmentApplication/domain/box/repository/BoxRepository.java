package com.mcmanuel.AssesmentApplication.domain.box;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Repository extends JpaRepository<BoxEntity,Integer> {

    Optional<BoxEntity> findByTxRef(String txRef);
}