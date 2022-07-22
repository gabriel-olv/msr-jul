package br.com.gabrieldeoliveira.msr.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Destinatario {
    
    private String nome;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;
}
