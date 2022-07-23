package br.com.gabrieldeoliveira.msr.api.model.ocorrencia;

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
public class OcorrenciaDeEntrada implements Serializable {
    static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 150)
    private String descricao;
}
