package br.com.gabrieldeoliveira.msr.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.models.Entrega;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoCancelaEntrega {
    
    private ServicoBuscaEntrega servicoCrudEntrega;

    @Transactional
    public void cancelar(Long entregaId) {
        Entrega entrega = servicoCrudEntrega.buscaId(entregaId);
        entrega.cancelar();
    }
}
