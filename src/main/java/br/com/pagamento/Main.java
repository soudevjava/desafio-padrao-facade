package br.com.pagamento;

import java.time.YearMonth;

import br.com.pagamento.facade.facade.PagamentoFacade;
import br.com.pagamento.facade.facade.ReciboPagamento;
import br.com.pagamento.facade.model.Cartao;

public class Main {
    public static void main(String[] args) {
    	Cartao cartaoOk = new Cartao("4111 1111 1111 1111", "Thiago Sales", YearMonth.now().plusMonths(24), "123");

        double valor = 259.90;

        PagamentoFacade facade = new PagamentoFacade();
        ReciboPagamento recibo = facade.pagar(cartaoOk, valor);

        System.out.println(recibo);

        // Exemplo de falha (cartão vencido)
        Cartao cartaoVencido = new Cartao("4539 1488 0343 6467", "Thiago Sales", YearMonth.now().minusMonths(1), "123");
        ReciboPagamento r2 = facade.pagar(cartaoVencido, 100.0);
        System.out.println(r2);
    }
}
