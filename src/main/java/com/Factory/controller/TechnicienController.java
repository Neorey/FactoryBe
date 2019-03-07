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

import com.Factory.entity.Technicien;
import com.Factory.repository.TechnicienRepository;

@Controller
@RequestMapping("/technicien")
public class TechnicienController {

	@Autowired
	private TechnicienRepository technicienRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeTechniciens", technicienRepository.findAll());
		return "technicien/list"; //test-
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		technicienRepository.deleteById(id);
		return "redirect:/technicien/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Technicien> opt=technicienRepository.findById(id);
		Technicien technicien=null;
		if(opt.isPresent()) {
			technicien=opt.get();
		} else {
			technicien= new Technicien();
		}
		return goEdit(technicien, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Technicien(), model);
	}
	
	public String goEdit(Technicien technicien, Model model) {
		model.addAttribute("technicien", technicien);
		return "technicien/edit";
	}
	
	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("technicien") Technicien technicien, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(technicien, model);
		}
		technicienRepository.save(technicien);
		return "redirect:/technicien/list";
	}
	
}