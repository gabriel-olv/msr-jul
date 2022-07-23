package br.com.gabrieldeoliveira.msr.domain.services;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.gabrieldeoliveira.msr.domain.model.Cliente;
import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.model.enums.StatusEntrega;
import br.com.gabrieldeoliveira.msr.domain.repositories.RepositorioEntrega;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoNovaEntrega {
    
    private RepositorioEntrega repositorioEntrega;
    private ServicoCrudCliente servicoCrudCliente;

    @Transactional
    public Entrega gerar(Entrega entrega) {
        Cliente cliente = servicoCrudCliente.idValido(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setDataPedido(OffsetDateTime.now());
        entrega.setStatus(StatusEntrega.PENDENTE);
 
        return repositorioEntrega.save(entrega);
    }
}
