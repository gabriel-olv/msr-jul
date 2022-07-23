package br.com.gabrieldeoliveira.msr.domain.exceptions;

public class EntidadeNaoEncontradaExcecao extends RuntimeException {

    public EntidadeNaoEncontradaExcecao(String mensagem) {
        super(mensagem);
    }
}
