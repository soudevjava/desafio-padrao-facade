package br.com.pagamento.facade.facade;

public class ReciboPagamento {
	private final boolean sucesso;
	private final String mensagem;
	private final String codigoAutorizacao;
	private final String comprovanteCaptura;
	private final String notaFiscal;
	
	public ReciboPagamento(boolean sucesso, String mensagem, String codigoAutorizacao, String comprovanteCaptura, String notaFiscal) {
		this.sucesso = sucesso;
		this.mensagem = mensagem;
		this.codigoAutorizacao = codigoAutorizacao;
		this.comprovanteCaptura = comprovanteCaptura;
		this.notaFiscal = notaFiscal;
		
		
		
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public String getComprovanteCaptura() {
		return comprovanteCaptura;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}
	@Override
	public String toString() {
        return """
                ReciboPagamento{
                  sucesso=%s,
                  mensagem='%s',
                  autorizacao='%s',
                  comprovante='%s',
                  notaFiscal='%s'
                }""".formatted(sucesso, mensagem, codigoAutorizacao, comprovanteCaptura, notaFiscal);
	}
	
	

}
