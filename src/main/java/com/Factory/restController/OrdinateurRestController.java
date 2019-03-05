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

import com.Factory.entity.Ordinateur;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.*;
import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("/rest/ordinateur")
public class OrdinateurRestController {
	
	@Autowired
	private OrdinateurRepository ordinateurRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Ordinateur>> list() {
		return new ResponseEntity<List<Ordinateur>>(ordinateurRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Ordinateur ordinateur, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		ordinateurRepository.save(ordinateur);
		URI uri = uCb.path("/rest/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Ordinateur> findById(@PathVariable("id") Long id) {
		Optional<Ordinateur> opt = ordinateurRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Ordinateur>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Ordinateur>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Ordinateur ordinateur, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Ordinateur> opt = ordinateurRepository.findById(id);
		if (opt.isPresent()) {
			Ordinateur ordinateurEnBase = opt.get();
			ordinateurEnBase.setCode(ordinateur.getCode());
			ordinateurEnBase.setCout(ordinateur.getCout());
			ordinateurEnBase.setDisponibilite(ordinateur.getDisponibilite());
			ordinateurEnBase.setDateAchat(ordinateur.getDateAchat());
			ordinateurEnBase.setMemoireDD(ordinateur.getMemoireDD());
			ordinateurEnBase.setProcesseur(ordinateur.getProcesseur());
			ordinateurEnBase.setQtRAM(ordinateur.getQtRAM());
			ordinateurEnBase.setStagiaire(ordinateur.getStagiaire());
			ordinateurRepository.save(ordinateurEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Ordinateur> delete(@PathVariable(name="id") Long id) {
		Optional<Ordinateur> opt = ordinateurRepository.findById(id);
		if (opt.isPresent()) {
			ordinateurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

