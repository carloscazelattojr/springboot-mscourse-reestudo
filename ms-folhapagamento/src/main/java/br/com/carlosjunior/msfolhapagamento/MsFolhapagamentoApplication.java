package br.com.carlosjunior.msfolhapagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsFolhapagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFolhapagamentoApplication.class, args);
	}

}
