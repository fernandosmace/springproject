package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.domain.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Integer>{
	
}
