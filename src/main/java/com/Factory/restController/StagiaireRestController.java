package com.Factory.restController;

import java.net.URI;
import java.util.List;
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


import com.Factory.entity.Stagiaire;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.StagiaireRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("/rest/stagiaire")
public class StagiaireRestController {
	
	@Autowired
	private StagiaireRepository stagiaireRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Stagiaire>> list() {
		return new ResponseEntity<List<Stagiaire>>(stagiaireRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Stagiaire stagiaire, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		stagiaireRepository.save(stagiaire);
		URI uri = uCb.path("/rest/stagiaire/{id}").buildAndExpand(stagiaire.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Stagiaire> findById(@PathVariable("id") Long id) {
		Optional<Stagiaire> opt = stagiaireRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Stagiaire>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Stagiaire>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Stagiaire stagiaire, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Stagiaire> opt = stagiaireRepository.findById(id);
		if (opt.isPresent()) {
			Stagiaire stagiaireEnBase = opt.get();
			stagiaireEnBase.setNom(stagiaire.getNom());
			stagiaireEnBase.setPrenom(stagiaire.getPrenom());
			stagiaireEnBase.setAdresse(stagiaire.getAdresse());
			stagiaireEnBase.setOrdinateur(stagiaire.getOrdinateur());
			stagiaireEnBase.setTel(stagiaire.getTel());
			stagiaireEnBase.setModule(stagiaire.getModule());
			stagiaireRepository.save(stagiaireEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Stagiaire> delete(@PathVariable(name="id") Long id) {
		Optional<Stagiaire> opt = stagiaireRepository.findById(id);
		if (opt.isPresent()) {
			stagiaireRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}