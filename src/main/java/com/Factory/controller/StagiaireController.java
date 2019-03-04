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

import com.Factory.entity.Stagiaire;
import com.Factory.repository.StagiaireRepository;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {

	@Autowired
	private StagiaireRepository stagiaireRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeStagiaire", stagiaireRepository.findAll());
		return "stagiaire/list"; //test-
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		stagiaireRepository.deleteById(id);
		return "redirect:/stagiaire/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Stagiaire> opt=stagiaireRepository.findById(id);
		Stagiaire stagiaire=null;
		if(opt.isPresent()) {
			stagiaire=opt.get();
		} else {
			stagiaire= new Stagiaire();
		}
		return goEdit(stagiaire, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Stagiaire(), model);
	}
	
	public String goEdit(Stagiaire stagiaire, Model model) {
		model.addAttribute("stagiaire", stagiaire);
		return "stagiaire/edit";
	}
	
	public String save(@Valid @ModelAttribute("stagiaire") Stagiaire stagiaire, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(stagiaire, model);
		}
		stagiaireRepository.save(stagiaire);
		return "redirect:/stagiaire/list";
	}
	
}
