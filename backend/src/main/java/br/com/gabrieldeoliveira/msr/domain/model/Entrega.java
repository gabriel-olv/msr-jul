package br.com.gabrieldeoliveira.msr.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gabrieldeoliveira.msr.domain.model.enums.StatusEntrega;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

    @EqualsAndHashCode.Include
    private Long id;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    private StatusEntrega status;

    private Cliente cliente;

    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    public Entrega(Long id,
            OffsetDateTime dataPedido,
            OffsetDateTime dataFinalizacao,
            StatusEntrega status,
            Cliente cliente) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.dataFinalizacao = dataFinalizacao;
        this.status = status;
        this.cliente = cliente;
    }
}
