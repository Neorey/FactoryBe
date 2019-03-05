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

import com.Factory.entity.Salle;
import com.Factory.repository.SalleRepository;

@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	private SalleRepository salleRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeSalle", salleRepository.findAll());
		return "salle/list"; 
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		salleRepository.deleteById(id);
		return "redirect:/salle/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Salle> opt=salleRepository.findById(id);
		Salle salle=null;
		if(opt.isPresent()) {
			salle=opt.get();
		} else {
			salle= new Salle();
		}
		return goEdit(salle, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Salle(), model);
	}

	
	public String goEdit(Salle salle, Model model) {
		model.addAttribute("salle", salle);
		return "salle/edit";
	}
	
	public String save(@Valid @ModelAttribute("salle") Salle salle, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(salle, model);
		}
		salleRepository.save(salle);
		return "redirect:/salle/list";
	}
}
