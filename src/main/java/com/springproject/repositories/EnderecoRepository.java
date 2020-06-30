package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}
