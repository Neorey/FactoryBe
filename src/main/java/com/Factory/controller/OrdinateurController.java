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

import com.Factory.entity.Ordinateur;
import com.Factory.repository.OrdinateurRepository;

@Controller
@RequestMapping("/ordinateur")
public class OrdinateurController {

	@Autowired
	private OrdinateurRepository ordinateurRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeOrdinateur", ordinateurRepository.findAll());
		return "ordinateur/list"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		ordinateurRepository.deleteById(id);
		return "redirect:/ordinateur/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Ordinateur> opt=ordinateurRepository.findById(id);
		Ordinateur ordinateur=null;
		if(opt.isPresent()) {
			ordinateur=opt.get();
		} else {
			ordinateur= new Ordinateur();
		}
		return goEdit(ordinateur, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Ordinateur(), model);
	}
	
	public String goEdit(Ordinateur ordinateur, Model model) {
		model.addAttribute("ordinateur", ordinateur);
		return "ordinateur/edit";
	}
	
	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("ordinateur") Ordinateur ordinateur, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(ordinateur, model);
		}
		ordinateurRepository.save(ordinateur);
		return "redirect:/ordinateur/list";
	}
}

