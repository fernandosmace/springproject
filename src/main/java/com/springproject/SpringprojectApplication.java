package com.springproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springproject.domain.Categoria;
import com.springproject.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringprojectApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Corrente");
		Categoria cat2 = new Categoria(null, "Poupança");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}