package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.domain.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
	
}
