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
import com.Factory.repository.FormateurRepository;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.*;

@RestController 
@RequestMapping("/rest/formateur")
public class FormateurRestController {
	@Autowired
	private FormateurRepository formateurRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Formateur>> list() {
		return new ResponseEntity<List<Formateur>>(formateurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Formateur formateur, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		formateurRepository.save(formateur);
		URI uri = uCb.path("/rest/formateur/{id}").buildAndExpand(formateur.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Formateur> findById(@PathVariable("id") Long id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Formateur>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Formateur>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Formateur formateur, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			Formateur formateurEnBase = opt.get();
			formateurEnBase.setNom(formateur.getNom());
			formateurEnBase.setPrenom(formateur.getPrenom());
			formateurEnBase.setTel(formateur.getTel());
			formateurEnBase.setListeMatiere(formateur.getListeMatiere());
			formateurEnBase.setModule(formateur.getModule());
			formateurRepository.save(formateurEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Formateur> delete(@PathVariable(name="id") Long id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			formateurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
