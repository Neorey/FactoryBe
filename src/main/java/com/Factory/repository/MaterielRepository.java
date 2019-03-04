package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Materiel;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long>{

}
