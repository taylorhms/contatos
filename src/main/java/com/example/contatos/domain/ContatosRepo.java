package com.example.contatos.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepo extends JpaRepository<Contato, Long> {

	public List<Contato> findByNomeContainingIgnoreCase(String str);
	
}
