package br.com.gabrieldeoliveira.msr.api.models.cliente;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteResumo implements Serializable {
    static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
    
    private String telefone;
}
