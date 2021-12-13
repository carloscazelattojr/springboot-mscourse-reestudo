package br.com.carlosjunior.msfolhapagamento.services;

import org.springframework.stereotype.Service;

import br.com.carlosjunior.msfolhapagamento.entities.Pagamento;

@Service
public class FolhaPagamentoService {

	public Pagamento getPagamento(Long funcionarioId, int days) {
		return new Pagamento("Carlos Junior", 200.0, days);
	}

}
