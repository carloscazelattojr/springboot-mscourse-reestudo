package br.com.carlosjunior.msfolhapagamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.msfolhapagamento.entities.Pagamento;
import br.com.carlosjunior.msfolhapagamento.services.FolhaPagamentoService;

@RestController
@RequestMapping("/folhapagamento")
public class FolhaPagamentoController {

	@Autowired
	private FolhaPagamentoService folhaPagamentoService;

	@GetMapping("/{funcionarioId}/days/{days}")
	public ResponseEntity<Pagamento> getPagamento(@PathVariable Long funcionarioId, @PathVariable Integer days) {
		Pagamento pagamento = folhaPagamentoService.getPagamento(funcionarioId, days);
		return ResponseEntity.ok(pagamento);

	}

}
