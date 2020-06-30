package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
}
