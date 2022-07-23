package br.com.gabrieldeoliveira.msr.api.models.ocorrencia;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OcorrenciaResumo implements Serializable {
    static final long serialVersionUID = 1L;

    private Long id;

    private String descricao;

    private OffsetDateTime dataRegistro;
}
