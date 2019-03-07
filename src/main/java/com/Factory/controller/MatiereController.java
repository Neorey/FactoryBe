package com.Factory.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Factory.entity.ENiveau;
import com.Factory.entity.Matiere;
import com.Factory.repository.MatiereRepository;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereRepository matiereRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeMatiere", matiereRepository.findAll());
		return "matiere/list"; //test-
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		matiereRepository.deleteById(id);
		return "redirect:/matiere/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Matiere> opt=matiereRepository.findById(id);
		Matiere matiere=null;
		if(opt.isPresent()) {
			matiere=opt.get();
		} else {
			matiere= new Matiere();
		}
		return goEdit(matiere, model);
		}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Matiere(), model);
	}
	
	public String goEdit(Matiere matiere, Model model) {
		model.addAttribute("matiere", matiere);
		model.addAttribute("allNiveau", ENiveau.values());
		return "matiere/edit";
	}
	
	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("matiere") Matiere matiere, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(matiere, model);
		}
		matiereRepository.save(matiere);
		return "redirect:/matiere/list";
	}
}
