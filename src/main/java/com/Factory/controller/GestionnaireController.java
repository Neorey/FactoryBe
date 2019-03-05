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

import com.Factory.entity.Gestionnaire;
import com.Factory.repository.GestionnaireRepository;


@Controller
@RequestMapping("/gestionnaire")
public class GestionnaireController {

	@Autowired
	private GestionnaireRepository gestionnaireRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeGestionnaire", gestionnaireRepository.findAll());
		return "gestionnaire/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		gestionnaireRepository.deleteById(id);
		return "redirect:/gestionnaire/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Gestionnaire> opt=gestionnaireRepository.findById(id);
		Gestionnaire gestionnaire=null;
		if(opt.isPresent()) {
			gestionnaire=opt.get();
		} else {
			gestionnaire= new Gestionnaire();
		}
		return goEdit(gestionnaire, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Gestionnaire(), model);
	}
	
	public String goEdit(Gestionnaire gestionnaire, Model model) {
		model.addAttribute("gestionnaire", gestionnaire);
		return "gestionnaire/edit";
	}
	
	public String save(@Valid @ModelAttribute("gestionnaire") Gestionnaire gestionnaire, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(gestionnaire, model);
		}
		gestionnaireRepository.save(gestionnaire);
		return "redirect:/gestionnaire/list";
	}
	
}
