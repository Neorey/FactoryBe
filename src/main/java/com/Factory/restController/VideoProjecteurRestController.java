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

import com.Factory.entity.VideoProjecteur;
import com.Factory.entity.jsonviews.JsonViews;
import com.Factory.repository.VideoProjecteurRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/videoProjecteur")
public class VideoProjecteurRestController {

	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<VideoProjecteur>> list() {
		return new ResponseEntity<List<VideoProjecteur>>(videoProjecteurRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insert(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br,
			UriComponentsBuilder uCb) {
		if (br.hasErrors())
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		videoProjecteurRepository.save(videoProjecteur);
		URI uri = uCb.path("/rest/videoProjecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<VideoProjecteur> findById(@PathVariable("id") Long id) {
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(id);
		if (opt.isPresent())
			return new ResponseEntity<VideoProjecteur>(opt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<VideoProjecteur>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br,
			@PathVariable(name = "id") Long id) {
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(id);
		if (opt.isPresent()) {
			VideoProjecteur videoProjecteurEnBase = opt.get();
			videoProjecteurEnBase.setCode(videoProjecteur.getCode());
			videoProjecteurEnBase.setCout(videoProjecteur.getCout());
			videoProjecteurEnBase.setDisponibilite(videoProjecteur.getDisponibilite());
			videoProjecteurEnBase.setDateAchat(videoProjecteur.getDateAchat());
			videoProjecteurEnBase.seteResolutionVideoProjecteur(videoProjecteur.geteResolutionVideoProjecteur());
			videoProjecteurRepository.save(videoProjecteurEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<VideoProjecteur> delete(@PathVariable(name="id") Long id) {
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(id);
		if (opt.isPresent()) {
			videoProjecteurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}