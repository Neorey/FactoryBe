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

import com.Factory.entity.Salle;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.SalleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/salle")
public class SalleRestController {

	@Autowired
	private SalleRepository salleRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Salle>> list() {
		return new ResponseEntity<List<Salle>>(salleRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Salle salle, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		salleRepository.save(salle);
		URI uri = uCb.path("/rest/salle/{id}").buildAndExpand(salle.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Salle> findById(@PathVariable("id") Long id) {
		Optional<Salle> opt = salleRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Salle>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Salle salle, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Salle> opt = salleRepository.findById(id);
		if (opt.isPresent()) {
			Salle salleEnBase = opt.get();
			salleEnBase.setCode(salle.getCode());
			salleEnBase.setCout(salle.getCout());
			salleEnBase.setDisponibilité(salle.getDisponibilité());
			salleEnBase.setCapacité(salle.getCapacité());
			salleEnBase.setModule(salle.getModule());
			salleEnBase.setNom(salle.getNom());
			salleRepository.save(salleEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Salle> delete(@PathParam("id") Long id) {
		Optional<Salle> opt = salleRepository.findById(id);
		if (opt.isPresent()) {
			salleRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}