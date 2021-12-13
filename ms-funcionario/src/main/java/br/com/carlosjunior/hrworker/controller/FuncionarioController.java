package br.com.carlosjunior.hrworker.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> list = funcionarioRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		return ResponseEntity.ok(funcionario);
	}
	

}
