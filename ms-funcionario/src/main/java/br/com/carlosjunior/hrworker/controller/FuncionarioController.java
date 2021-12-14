package br.com.carlosjunior.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.hrworker.entities.Funcionario;
import br.com.carlosjunior.hrworker.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	private static Logger logger = LoggerFactory.getLogger(FuncionarioController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> list = funcionarioRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		logger.info("Porta: " + env.getProperty("local.server.port"));
		
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		return ResponseEntity.ok(funcionario);
	}
	

}
