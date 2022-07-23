package br.com.gabrieldeoliveira.msr.api.model.entrega;

import java.io.Serializable;

import javax.validation.Valid;

import br.com.gabrieldeoliveira.msr.api.model.cliente.ClienteRef;
import br.com.gabrieldeoliveira.msr.api.model.destinatario.DestinatarioDeEntrada;
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
    private ClienteRef cliente;

    @Valid
    private DestinatarioDeEntrada destinatario;
}
