package br.com.gabrieldeoliveira.msr.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEntrega {
    PENDENTE(0,"Pendente"),
    FINALIZADA(1, "Finalizada"),
    CANCELADA(2, "Cancelada");

    private Integer codigo;
    
    private String descricao;
}
