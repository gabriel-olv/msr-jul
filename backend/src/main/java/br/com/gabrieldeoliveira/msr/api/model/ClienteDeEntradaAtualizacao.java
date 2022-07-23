package br.com.gabrieldeoliveira.msr.api.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDeEntradaAtualizacao implements Serializable {
    static final long serialVersionUID = 1L;

    private String nome;

    private String email;

    private String telefone;
}
