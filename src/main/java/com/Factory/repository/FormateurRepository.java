package com.Factory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{
	

//	List<Formateur> findAllWithMatiere();

}
