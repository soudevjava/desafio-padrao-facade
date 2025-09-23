package br.com.pagamento.facade.core;

import java.util.UUID;

public class ServicoNotaFiscal {
	public String emitirNota(String titular, double valor) {
		// Simular emissão de NF
		 return "NF-" + UUID.randomUUID() + " para " + titular + " no valor de R$ " + String.format("%.2f", valor);
		   
	}
}
