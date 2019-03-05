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

import com.Factory.entity.Materiel;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.MaterielRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("/rest/materiel")
public class MaterielRestController {
	
	@Autowired
	private MaterielRepository materielRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Materiel>> list() {
		return new ResponseEntity<List<Materiel>>(materielRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Materiel materiel, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		materielRepository.save(materiel);
		URI uri = uCb.path("/rest/materiel/{id}").buildAndExpand(materiel.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Materiel> findById(@PathVariable("id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Materiel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Materiel materiel, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if (opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCode(materiel.getCode());
			materielEnBase.setCout(materiel.getCout());
			materielEnBase.setDisponibilité(materiel.getDisponibilité());
			materielRepository.save(materielEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Materiel> delete(@PathParam("id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if (opt.isPresent()) {
			materielRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}