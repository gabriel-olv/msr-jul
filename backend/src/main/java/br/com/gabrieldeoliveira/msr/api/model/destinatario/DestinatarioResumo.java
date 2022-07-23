package br.com.gabrieldeoliveira.msr.api.model.destinatario;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DestinatarioResumo implements Serializable {
    static final long serialVersionUID = 1L;

    private String nome;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;
}
