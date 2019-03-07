package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
