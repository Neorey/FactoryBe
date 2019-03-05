package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Technicien;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

}
