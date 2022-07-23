package br.com.gabrieldeoliveira.msr.domain.exceptions;

public class ArgumentoInvalidoExcecao extends RuntimeException {

    public ArgumentoInvalidoExcecao(String mensagem) {
        super(mensagem);
    }
}
