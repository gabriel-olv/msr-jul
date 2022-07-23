package br.com.gabrieldeoliveira.msr.api.models.entrega;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.gabrieldeoliveira.msr.api.models.cliente.ClienteRef;
import br.com.gabrieldeoliveira.msr.api.models.destinatario.DestinatarioDeEntrada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntregaDeEntrada implements Serializable {
    static final long serialVersionUID = 1L;

    @Valid
    @NotNull
    private ClienteRef cliente;

    @Valid
    @NotNull
    private DestinatarioDeEntrada destinatario;
}
