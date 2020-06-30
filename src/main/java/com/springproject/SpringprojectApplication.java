package com.springproject;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springproject.domain.Cartao;
import com.springproject.domain.Categoria;
import com.springproject.domain.Cliente;
import com.springproject.domain.Conta;
import com.springproject.domain.Endereco;
import com.springproject.domain.Fatura;
import com.springproject.repositories.CartaoRepository;
import com.springproject.repositories.CategoriaRepository;
import com.springproject.repositories.ClienteRepository;
import com.springproject.repositories.ContaRepository;
import com.springproject.repositories.EnderecoRepository;
import com.springproject.repositories.FaturaRepository;

@SpringBootApplication
public class SpringprojectApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	FaturaRepository faturaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Gerando os endereços
		Endereco endereco1 = new Endereco(null, "Avenida Netuno", "2440", "Centro", "Atlântida", "Oceano");
		Endereco endereco2 = new Endereco(null, "Avenida 1", "8550", "Lyntown", "Gotham", "New Jersey");
		Endereco endereco3 = new Endereco(null, "Avenida Luthor", "141", "Downtown", "Metropolis", "Delaware");
		
		//Instanciando clientes
		Cliente cliente1 = new Cliente(null, "Fernando", "85999999999", "fernando@email.com");
		Cliente cliente2 = new Cliente(null, "Carolline", "11888888888", "carollin@email.com");
		Cliente cliente3 = new Cliente(null, "Marcelo", "41555555555", "marcelo@email.com");
		
		//Instanciando as categorias
		Categoria cat1 = new Categoria(null, "Bronze");
		Categoria cat2 = new Categoria(null, "Silver");
		Categoria cat3 = new Categoria(null, "Gold");
		
		//Instanciando contas
		Conta conta1 = new Conta(null, 123456789, 6214.10, true, cat2, cliente2);
		Conta conta2 = new Conta(null, 987654321, 125.44, true, cat1, cliente1);
		Conta conta3 = new Conta(null, 123456789, 55481.84, true, cat3, cliente3);
		
		//Instanciando Cartões
		
		Cartao cartao1 = new Cartao(null, 316546564, sdf.parse("05/06/2022"), cliente1.getNome(), 456, "256474", conta1);
		Cartao cartao2 = new Cartao(null, 687332113, sdf.parse("06/07/2023"), cliente2.getNome(), 861, "374981", conta3);
		Cartao cartao3 = new Cartao(null, 981632715, sdf.parse("07/08/2024"), cliente3.getNome(), 617, "648197", conta2);
		
		//Instanciando Faturas
		Fatura fatura1 = new Fatura(null, sdf.parse("29/05/2020"), sdf.parse("29/05/2020"), 0, true, 400.22, cartao1);
		Fatura fatura2 = new Fatura(null, sdf.parse("29/05/2020"), sdf.parse("29/05/2020"), 0, true, 320.66, cartao1);
		Fatura fatura3 = new Fatura(null, sdf.parse("29/05/2020"), sdf.parse("29/05/2020"), 0, true, 150.12, cartao1);
		
		Fatura fatura4 = new Fatura(null, sdf.parse("30/06/2020"), sdf.parse("30/06/2020"), 0, true, 16.41, cartao2);
		Fatura fatura5 = new Fatura(null, sdf.parse("30/06/2020"), sdf.parse("30/06/2020"), 0, true, 10.21, cartao2);
		Fatura fatura6 = new Fatura(null, sdf.parse("30/06/2020"), sdf.parse("30/06/2020"), 0, true, 11.87, cartao2);

		Fatura fatura7 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("01/07/2020"), 0, true, 875.40, cartao3);
		Fatura fatura8 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("01/07/2020"), 0, true, 1200.78, cartao3);
		Fatura fatura9 = new Fatura(null, sdf.parse("01/07/2020"), sdf.parse("01/07/2020"), 0, true, 1200.78, cartao3);
		
		
		//Relacionando Contas aos clientes
		cliente1.setConta(conta2);
		cliente2.setConta(conta1);
		cliente3.setConta(conta3);
		
		//Relacionando endereços aos clientes
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1));
		cliente2.getEnderecos().addAll(Arrays.asList(endereco2));
		cliente3.getEnderecos().addAll(Arrays.asList(endereco3));
		
		//Relacionando cartões às contas
		conta1.getCartoes().addAll(Arrays.asList(cartao1));
		conta2.getCartoes().addAll(Arrays.asList(cartao2));
		conta3.getCartoes().addAll(Arrays.asList(cartao3));
		
		//Relacionando faturas aos cartões
		cartao1.getFaturas().addAll(Arrays.asList(fatura1, fatura2, fatura3));
		cartao2.getFaturas().addAll(Arrays.asList(fatura4, fatura5, fatura6));
		cartao3.getFaturas().addAll(Arrays.asList(fatura7, fatura8, fatura9));
	

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		contaRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
		cartaoRepository.saveAll(Arrays.asList(cartao1, cartao2, cartao3));
		faturaRepository.saveAll(Arrays.asList(fatura1, fatura2, fatura3, fatura4, fatura5, fatura6, fatura7, fatura8));
		
	}

}