package br.com.carlosjunior.msfolhapagamento.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.carlosjunior.msfolhapagamento.entities.Funcionario;
import br.com.carlosjunior.msfolhapagamento.entities.Pagamento;

@Service
public class FolhaPagamentoService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ms-funcionario.host}")
	private String hostMsFuncionario;

	public Pagamento getPagamento(Long funcionarioId, int days) {

		Map<String, String> uriVariaveis = new HashMap<>();
		uriVariaveis.put("id", "" + funcionarioId);

		Funcionario funcionario = restTemplate.getForObject(hostMsFuncionario + "/funcionarios/{id}",Funcionario.class, uriVariaveis);

		return new Pagamento(funcionario.getName(), funcionario.getDailyIncome(), days);
	}

}
