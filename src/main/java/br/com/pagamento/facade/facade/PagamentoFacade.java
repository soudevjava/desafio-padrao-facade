// file: br/com/pagamento/facade/facade/PagamentoFacade.java
package br.com.pagamento.facade.facade;

import br.com.pagamento.facade.core.*;
import br.com.pagamento.facade.model.Cartao;

public class PagamentoFacade {

    private final ValidadorCartao validador;
    private final AutorizadorPagamento autorizador;
    private final ProcessadorPagamento processador;
    private final ServicoNotaFiscal servicoNF;

    public PagamentoFacade() {
        this.validador = new ValidadorCartao();
        this.autorizador = new AutorizadorPagamento();
        this.processador = new ProcessadorPagamento();
        this.servicoNF = new ServicoNotaFiscal();
    }

    // Construtor alternativo para injeção (teste/mocks)
    public PagamentoFacade(ValidadorCartao v, AutorizadorPagamento a, ProcessadorPagamento p, ServicoNotaFiscal n) {
        this.validador = v;
        this.autorizador = a;
        this.processador = p;
        this.servicoNF = n;
    }

    public ReciboPagamento pagar(Cartao cartao, double valor) {
        try {
            // 1) validar
            validador.validar(cartao);

            // 2) autorizar
            AutorizacaoResposta auth = autorizador.autorizar(cartao, valor);
            if (!auth.aprovado()) {
                return new ReciboPagamento(false, "Autorização negada: " + auth.mensagem(), null, null, null);
            }

            // 3) processar (capturar)
            ProcessamentoResposta proc = processador.processar(auth.codigoAutorizacao(), valor);
            if (!proc.sucesso()) {
                return new ReciboPagamento(false, "Falha no processamento: " + proc.mensagem(), auth.codigoAutorizacao(), null, null);
            }

            // 4) emitir NF
            String nf = servicoNF.emitirNota(cartao.getTitular(), valor);

            return new ReciboPagamento(
            	    true,
            	    "Pagamento concluído.",
            	    auth.codigoAutorizacao(),   // certo → código da autorização
            	    proc.comprovanteId(),       // aqui tem que ser o ID de captura
            	    nf                          // nota fiscal
            	);


        } catch (ValidacaoException e) {
            return new ReciboPagamento(false, "Validação falhou: " + e.getMessage(), null, null, null);
        } catch (Exception e) {
            return new ReciboPagamento(false, "Erro inesperado: " + e.getMessage(), null, null, null);
        }
    }
}
