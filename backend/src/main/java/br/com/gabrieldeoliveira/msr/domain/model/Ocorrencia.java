package br.com.gabrieldeoliveira.msr.domain.model;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ocorrencia {
    
    private Long id;

    private String descricao;

    private OffsetDateTime dataRegistro;
}
