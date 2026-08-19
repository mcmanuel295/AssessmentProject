package com.mcmanuel.AssesmentApplication.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


interface Repository extends JpaRepository<BoxEntity,Integer> {

    Optional<BoxEntity> findByTxRef(String txRef);
}