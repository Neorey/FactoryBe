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

import com.Factory.entity.Formateur;
import com.Factory.repository.FormateurRepository;
import com.Factory.repository.MatiereRepository;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("listeFormateur", formateurRepository.findAllWithMatiere());
		return "formateur/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name="id") Long id, Model model) {
		formateurRepository.deleteById(id);
		return "redirect:/formateur/list";	
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam(name="id") Long id, Model model) {
		Optional<Formateur> opt=formateurRepository.findById(id);
		Formateur formateur=null;
		if(opt.isPresent()) {
			formateur=opt.get();
		} else {
			formateur=new Formateur();
		}
		return goEdit(formateur, model);
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Formateur(), model);
	}
	
	public String goEdit(Formateur formateur, Model model) {
		model.addAttribute("formateur", formateur);
		return "formateur/edit";
	}
	
	@GetMapping("/save")
	public String save(@ModelAttribute("formateur") Formateur formateur, BindingResult br, Model model) {
		if (br.hasErrors()) { // hasErrors determine si ya une erreur, cest un booleen
			return goEdit(formateur, model);
		}
		formateurRepository.save(formateur);
		return "redirect:/formateur/list";
	}
}
