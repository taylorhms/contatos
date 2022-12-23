package com.example.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contatos.domain.Contato;
import com.example.contatos.domain.ContatosRepo;

@RestController
@RequestMapping("/contatos")
public class ContatoRest {

	@Autowired
	private ContatosRepo contatosRepo;

	@GetMapping
	public List<Contato> lerTodos() {
		return contatosRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Contato ler(@PathVariable Long id) {
		return contatosRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/buscar/{str}")
	public List<Contato> buscarPorNome(@PathVariable String str) {
		return contatosRepo.findByNomeContainingIgnoreCase(str);
	}
	
	@PostMapping
	public Contato inserir(@RequestBody Contato contato) {
		return contatosRepo.save(contato);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		contatosRepo.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Contato atualizar(@RequestBody Contato contato) {
		return contatosRepo.save(contato);
	}
}
