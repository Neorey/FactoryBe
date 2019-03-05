package com.Factory.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.Factory.entity.*;


@Configuration
public class CustomRepositoryRestConfigurer implements RepositoryRestConfigurer {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Formateur.class,Formation.class,Materiel.class,Matiere.class,Stagiaire.class);
	}

}

