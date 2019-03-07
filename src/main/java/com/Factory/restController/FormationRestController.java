package com.Factory.restController;
import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Factory.entity.*;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.FormationRepository;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.*;

@RestController 
@RequestMapping("/rest/formation")
public class FormationRestController {
	
	@Autowired
	private FormationRepository formationRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Formation>> list() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Formation formation, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		formationRepository.save(formation);
		URI uri = uCb.path("/rest/formation/{id}").buildAndExpand(formation.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Formation> findById(@PathVariable("id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Formation>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Formation formation, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			Formation formationEnBase = opt.get();
			formationEnBase.setNomFormation(formation.getNomFormation());
			formationEnBase.setListModules(formation.getListModules());
			formationEnBase.setGestionnaire(formation.getGestionnaire());
			formationRepository.save(formationEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Formation> delete(@PathVariable(name="id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			formationRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}

