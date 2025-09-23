package br.com.pagamento.facade.core;



public class ProcessadorPagamento {
	public ProcessamentoResposta processar(String codigoAutorizacao, double valor) {
	    if (codigoAutorizacao == null) {
	        return new ProcessamentoResposta(false, null, "Sem autorização.");
	    }
	    String comprovante = "CAP-" + java.util.UUID.randomUUID();
	    return new ProcessamentoResposta(true, comprovante, "Pagamento capturado com sucesso.");
	}

}
