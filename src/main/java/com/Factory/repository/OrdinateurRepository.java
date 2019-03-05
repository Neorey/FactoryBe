package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Factory.entity.*;

public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {

}
