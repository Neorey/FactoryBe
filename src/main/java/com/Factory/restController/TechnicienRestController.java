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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Factory.entity.Technicien;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.TechnicienRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="http://localhost:4200")
@RestController 
@RequestMapping("/rest/technicien")
public class TechnicienRestController {
	
	@Autowired
	private TechnicienRepository technicienRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Technicien>> list() {
		return new ResponseEntity<List<Technicien>>(technicienRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Technicien technicien, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		technicienRepository.save(technicien);
		URI uri = uCb.path("/rest/technicien/{id}").buildAndExpand(technicien.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Technicien> findById(@PathVariable("id") Long id) {
		Optional<Technicien> opt = technicienRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Technicien>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Technicien>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Technicien technicien, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Technicien> opt = technicienRepository.findById(id);
		if (opt.isPresent()) {
			Technicien technicienEnBase = opt.get();
			technicienEnBase.setNom(technicien.getNom());
			technicienEnBase.setPrenom(technicien.getPrenom());
			technicienEnBase.setAdresse(technicien.getAdresse());
			technicienEnBase.setTel(technicien.getTel());
			technicienRepository.save(technicienEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Technicien> delete(@PathVariable(name="id") Long id) {
		Optional<Technicien> opt = technicienRepository.findById(id);
		if (opt.isPresent()) {
			technicienRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}

