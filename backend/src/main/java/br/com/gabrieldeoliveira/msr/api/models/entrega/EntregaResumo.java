package br.com.gabrieldeoliveira.msr.api.models.entrega;

import java.io.Serializable;
import java.time.OffsetDateTime;

import br.com.gabrieldeoliveira.msr.api.models.cliente.ClienteResumo;
import br.com.gabrieldeoliveira.msr.api.models.destinatario.DestinatarioResumo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntregaResumo implements Serializable {
    static final long serialVersionUID = 1L;

    private Long id;

    private OffsetDateTime dataPedido;

    private OffsetDateTime dataFinalizacao;

    private String status;

    private ClienteResumo cliente;

    private DestinatarioResumo destinatario;
}
