package br.com.pagamento.facade.core;

public class AutorizacaoResposta {
	private final boolean aprovado;
	private final String codigoAutorizacao;
	private final String mensagem;

	public AutorizacaoResposta(boolean aprovado, String codigoAutorizacao, String mensagem) {
		this.aprovado = aprovado;
		this.codigoAutorizacao = codigoAutorizacao;
		this.mensagem = mensagem;
	}


    public boolean aprovado() { return aprovado; }
    public String codigoAutorizacao() { return codigoAutorizacao; }
    public String mensagem() { return mensagem; }
}


