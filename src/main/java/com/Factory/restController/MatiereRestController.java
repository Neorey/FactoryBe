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

import com.Factory.entity.Matiere;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.MatiereRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController 
@RequestMapping("/rest/materiel")
public class MatiereRestController {
	
	@Autowired
	private MatiereRepository matiereRepository;
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Matiere>> list() {
		return new ResponseEntity<List<Matiere>>(matiereRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody Matiere matiere, BindingResult br, UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		matiereRepository.save(matiere);
		URI uri = uCb.path("/rest/matiere/{id}").buildAndExpand(matiere.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Matiere> findById(@PathVariable("id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Matiere>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody Matiere matiere, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setContenu(matiere.getContenu());
			matiereEnBase.setDuree(matiere.getDuree());
			matiereEnBase.setListeFormateur(matiere.getListeFormateur());
			matiereEnBase.setModule(matiere.getModule());
			matiereEnBase.setNiveau(matiere.getNiveau());
			matiereEnBase.setObjectifs(matiere.getObjectifs());
			matiereEnBase.setPrerequis(matiere.getPrerequis());
			matiereEnBase.setTitre(matiere.getTitre());
			matiereRepository.save(matiereEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Matiere> delete(@PathParam("id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			matiereRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
