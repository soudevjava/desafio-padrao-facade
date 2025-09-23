package br.com.pagamento.facade.core;

import java.util.Random;

import br.com.pagamento.facade.model.Cartao;

public class AutorizadorPagamento {
	private final Random rnd = new Random();
	
	public AutorizacaoResposta autorizar(Cartao cartao, double valor) {
	// Regra fictício: reprova valore muito alto só pra simullar
	if (valor <= 0) {
	return new AutorizacaoResposta(false, null, "Valor inválido.");
	}
	if (valor > 1000) {
		return new AutorizacaoResposta(false, null, "Limite execito na operadora.");
	}
	// simula um código de autorização
	String auth = "AUTH-" + (100000 + rnd.nextInt(900000));
	return new AutorizacaoResposta(true, auth, "Transação autorizada.");
	
	}
}
