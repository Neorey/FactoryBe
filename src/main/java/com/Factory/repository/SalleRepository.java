package com.Factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Factory.entity.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long>{
	
//	Ce module servira à évaluer les prévisions salle en fonction du stock disponible afin d’estimer si des achats supplémentaires seront nécessaires.
//	Il faut donc offrir une vue prévisionnel à 6 mois de l’utilisation du matériel et afficher des alertes visuelles sur les dates hors stock.


}
