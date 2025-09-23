package br.com.pagamento.facade.core;

public class ProcessamentoResposta {
	private final boolean sucesso;
    private final String comprovanteId;
    private final String mensagem;

    public ProcessamentoResposta(boolean sucesso, String comprovanteId, String mensagem) {
        this.sucesso = sucesso;
        this.comprovanteId = comprovanteId;
        this.mensagem = mensagem;
    }


    public boolean sucesso() { return sucesso; }
    public String comprovanteId() { return comprovanteId; }
    public String mensagem() { return mensagem; }
}
