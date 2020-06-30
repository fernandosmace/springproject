package com.springproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.domain.Conta;
import com.springproject.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

}
