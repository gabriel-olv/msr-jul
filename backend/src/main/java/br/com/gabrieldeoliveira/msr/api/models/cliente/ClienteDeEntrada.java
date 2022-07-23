package br.com.gabrieldeoliveira.msr.api.models.cliente;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDeEntrada implements Serializable {
    static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 60)
    private String nome;
    
    @NotBlank
    @Size(max = 60)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;
}
