package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
