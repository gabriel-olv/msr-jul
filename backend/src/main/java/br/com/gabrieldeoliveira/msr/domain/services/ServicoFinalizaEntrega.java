package br.com.gabrieldeoliveira.msr.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.models.Entrega;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoFinalizaEntrega {
    
    private ServicoBuscaEntrega servicoCrudEntrega;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = servicoCrudEntrega.buscaId(entregaId);
        entrega.finalizar();
    }
}
