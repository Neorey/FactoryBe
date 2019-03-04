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

import com.Factory.entity.Materiel;
import com.Factory.entity.Ordinateur;
import com.Factory.entity.Salle;
import com.Factory.entity.VideoProjecteur;
import com.Factory.repository.MaterielRepository;

@Controller
@RequestMapping("/materiel")
public class MaterielController {

	@Autowired
	private MaterielRepository materielRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeMateriel", materielRepository.findAll());
		return "materiel/list"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		materielRepository.deleteById(id);
		return "redirect:/materiel/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Materiel> opt=materielRepository.findById(id);
		Materiel materiel=null;
		
		return goEdit(materiel, model);
		}
	
	@GetMapping("/addOrdi")
	public String addOrdi(Model model) {
		return goEdit(new Ordinateur(), model);
	}
	@GetMapping("/addVideoproj")
	public String addVideoproj(Model model) {
		return goEdit(new VideoProjecteur(), model);
	}
	@GetMapping("/addSalle")
	public String addSalle(Model model) {
		return goEdit(new Salle(), model);
	}
	
	public String goEdit(Materiel materiel, Model model) {
		model.addAttribute("materiel", materiel);
		return "materiel/edit";
	}
	
	public String save(@Valid @ModelAttribute("materiel") Materiel materiel, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(materiel, model);
		}
		materielRepository.save(materiel);
		return "redirect:/materiel/list";
	}
}
