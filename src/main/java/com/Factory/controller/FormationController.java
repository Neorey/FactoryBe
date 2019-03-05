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

import com.Factory.entity.Formation;
import com.Factory.entity.Module;
import com.Factory.repository.FormationRepository;


@Controller
@RequestMapping("/formation")
public class FormationController {

	@Autowired
	private FormationRepository formationRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeformation", formationRepository.findAll());
		return "formation/list"; //test-
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		formationRepository.deleteById(id);
		return "redirect:/formation/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Formation> opt=formationRepository.findById(id);
		Formation formation=null;
		if(opt.isPresent()) {
			formation=opt.get();
		} else {
			formation= new Formation();
		}
		return goEdit(formation, model);
		}
	
	@GetMapping("/addModel")
	public String addModel(Model model) {
		return goEdit(new Formation(), model);
	}
	
	@GetMapping("/addModule")
	public String addModule(Model model) {
		return goEditModule(new Module(), model);
	}
	
	public String goEdit(Formation formation, Model model) {
		model.addAttribute("formation", formation);
		return "formation/edit";
	}
	
	public String goEditModule(Module module, Model model) {
		model.addAttribute("module", module);
		return "formation/edit";
	}
	
	public String save(@Valid @ModelAttribute("formation") Formation formation, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(formation, model);
		}
		formationRepository.save(formation);
		return "redirect:/formation/list";
	}
	
}
