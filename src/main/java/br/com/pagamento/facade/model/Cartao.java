package br.com.pagamento.facade.model;

import java.time.YearMonth;
import java.util.Objects;
/*YearMonth [AnoMês é um objeto de data e hora 
 *imutável que representa a combinação de um  de ano e um mês.]*/

public class Cartao {
	private final String numero;
	private final String titular;
	private final YearMonth validade; // exe: 2007-09
	private final String cvv;

	public Cartao(String numero, String titular, YearMonth validade, String cvv) {
		this.numero = Objects.requireNonNull(numero);
		this.titular = Objects.requireNonNull(titular);
		this.validade = Objects.requireNonNull(validade);
		this.cvv = Objects.requireNonNull(cvv);
	}

	public String getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public YearMonth getValidade() {
		return validade;
	}

	public String getCvv() {
		return cvv;
	}


	@Override
	public String toString() {
		String ultimos4 = numero.length() >=4 ? numero.substring(numero.length() -4) : numero;
		return "Cartao {**** **** **** " + ultimos4 + ", titular='" + titular + "'}";
	}
	
}
