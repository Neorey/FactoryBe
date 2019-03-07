package com.Factory.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Factory.entity.VideoProjecteur;
import com.Factory.repository.VideoProjecteurRepository;

@Controller
@RequestMapping("/videoProjecteur")
public class VideoProjecteurController {

	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeVideoProjecteur", videoProjecteurRepository.findAll());
		return "videoProjecteur/list"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		videoProjecteurRepository.deleteById(id);
		return "redirect:/videoProjecteur/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<VideoProjecteur> opt=videoProjecteurRepository.findById(id);
		VideoProjecteur videoProjecteur=null;
		if(opt.isPresent()) {
			videoProjecteur=opt.get();
		} else {
			videoProjecteur= new VideoProjecteur();
		}
		return goEdit(videoProjecteur, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new VideoProjecteur(), model);
	}

	
	public String goEdit(VideoProjecteur videoProjecteur, Model model) {
		model.addAttribute("videoProjecteur", videoProjecteur);
		return "videoProjecteur/edit";
	}
	
	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("videoProjecteur") VideoProjecteur videoProjecteur, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(videoProjecteur, model);
		}
		videoProjecteurRepository.save(videoProjecteur);
		return "redirect:/videoProjecteur/list";
	}
}
