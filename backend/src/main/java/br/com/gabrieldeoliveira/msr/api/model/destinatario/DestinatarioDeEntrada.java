package br.com.gabrieldeoliveira.msr.api.model.destinatario;

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
public class DestinatarioDeEntrada implements Serializable {
    static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String logradouro;

    @NotBlank
    @Size(max = 10)
    private String numero;

    @Size(max = 60)
    private String complemento;

    @NotBlank
    @Size(max = 30)
    private String bairro;
}
