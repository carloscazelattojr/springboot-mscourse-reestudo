package br.com.carlosjunior.msfolhapagamento.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.carlosjunior.msfolhapagamento.entities.Funcionario;

@Component
@FeignClient(name = "ms-funcionario", url = "localhost:8001", path = "/funcionarios")
public interface FuncionarioFeignClient {

	@GetMapping("/{id}")
	ResponseEntity<Funcionario> findById(@PathVariable Long id);
	
}
