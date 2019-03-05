package com.Factory.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

import com.Factory.entity.Gestionnaire;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.GestionnaireRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/gestionnaire")
public class GestionnaireRestController {

	@Autowired
	private GestionnaireRepository gestionnaireRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Gestionnaire>> list() {
		return new ResponseEntity<List<Gestionnaire>>(gestionnaireRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult br,
			UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		gestionnaireRepository.save(gestionnaire);
		URI uri = uCb.path("/rest/gestionnaire/{id}").buildAndExpand(gestionnaire.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Gestionnaire> findById(@PathVariable("id") Long id) {
		Optional<Gestionnaire> opt = gestionnaireRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Gestionnaire>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Gestionnaire>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Gestionnaire> opt = gestionnaireRepository.findById(id);
		if (opt.isPresent()) {
			Gestionnaire gestionnaireEnBase = opt.get();
			gestionnaireEnBase.setNom(gestionnaire.getNom());
			gestionnaireEnBase.setPrenom(gestionnaire.getPrenom());
			gestionnaireEnBase.setAdresse(gestionnaire.getAdresse());
			gestionnaireEnBase.setTel(gestionnaire.getTel());
			gestionnaireEnBase.setModule(gestionnaire.getModule());
			gestionnaireEnBase.setFormation(gestionnaire.getFormation());
			gestionnaireRepository.save(gestionnaireEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Gestionnaire> delete(@PathParam("id") Long id) {
		Optional<Gestionnaire> opt = gestionnaireRepository.findById(id);
		if (opt.isPresent()) {
			gestionnaireRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}