package br.com.pagamento.facade.core;

import java.time.YearMonth;

import br.com.pagamento.facade.model.Cartao;

public class ValidadorCartao {
	public void validar(Cartao cartao) {
		if (!numeroPlausivel(cartao.getNumero())) {
			throw new ValidacaoException("Numero do cartão Inválido.");
		}
		if (cartao.getCvv().length() < 3 || cartao.getCvv().length() > 4) {
			throw new ValidacaoException("Cvv inválido.");
		} if (cartao.getValidade().isBefore(YearMonth.now())) {
			throw new ValidacaoException("Cartão vencido");
		}

	}
	// Versão simples da validação de Luhn (ou Checagem básica)
	private boolean numeroPlausivel(String numero) {
	    String digits = numero.replaceAll("\\s+", "");
	    return digits.matches("\\d{13,19}"); // apenas checa tamanho e se é numérico
	}



}
