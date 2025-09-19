# Desafio — Padrão de Projeto Facade em Java

## 📌 Objetivo
Implementar o padrão de projeto **Facade**, criando uma interface simples para realizar pagamentos sem que o cliente precise conhecer os subsistemas internos (validação, autorização, processamento e emissão de nota fiscal).

---

## 📂 Estrutura do Projeto
- `Cartao.java` → Representa os dados do cartão.
- `ValidadorCartao.java` → Responsável por validar o cartão.
- `AutorizadorPagamento.java` → Simula a autorização junto à operadora.
- `ProcessadorPagamento.java` → Processa o pagamento.
- `ServicoNotaFiscal.java` → Gera a nota fiscal.
- `PagamentoFacade.java` → Classe **Facade**, que centraliza e simplifica a interação com os subsistemas.
- `Main.java` → Classe cliente que consome a fachada.

---

## 🚀 Como Executar
1. Clone o repositório ou copie os arquivos.
2. Compile o projeto:
   ```bash
   javac com/exemplo/facade/*.java

## 💡 Conceitos Praticados
- Padrão de projeto Facade
- Encapsulamento da complexidade
- Separação de responsabilidades
- Uso prático em sistemas de pagamento

## 🎯 Desafio Extra
- Criar suporte a débito e PIX com novos subsistemas.
- Registrar os pagamentos em um arquivo de log.
- Implementar testes unitários para os subsistemas.

