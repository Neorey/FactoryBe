package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Stagiaire;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

}
