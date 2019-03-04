package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
