package br.com.pagamento.facade.core;

public class ValidacaoException extends RuntimeException{
	public ValidacaoException(String msq) {
		super(msq);
	}
}
