package br.com.carlosjunior.msfolhapagamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosjunior.msfolhapagamento.entities.Funcionario;
import br.com.carlosjunior.msfolhapagamento.entities.Pagamento;
import br.com.carlosjunior.msfolhapagamento.feignclient.FuncionarioFeignClient;

@Service
public class FolhaPagamentoService {

	/*
	 * - Exemplo com RestTemplate
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Value("${ms-funcionario.host}") private String hostMsFuncionario;
	 * 
	 * public Pagamento getPagamento(Long funcionarioId, int days) {
	 * 
	 * Map<String, String> uriVariaveis = new HashMap<>(); uriVariaveis.put("id", ""
	 * + funcionarioId);
	 * 
	 * Funcionario funcionario = restTemplate.getForObject(hostMsFuncionario +
	 * "/funcionarios/{id}",Funcionario.class, uriVariaveis);
	 * 
	 * return new Pagamento(funcionario.getName(), funcionario.getDailyIncome(),
	 * days); }
	 * 
	 */

	// Exemplo com Feign
	@Autowired
	private FuncionarioFeignClient funcionarioFeignClient;

	public Pagamento getPagamento(Long funcionarioId, int days) {
		Funcionario funcionario = funcionarioFeignClient.findById(funcionarioId).getBody();
		return new Pagamento(funcionario.getName(), funcionario.getDailyIncome(), days);
	}

}
