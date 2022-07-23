package br.com.gabrieldeoliveira.msr.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.models.Entrega;
import br.com.gabrieldeoliveira.msr.domain.models.Ocorrencia;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoGeraOcorrencia {

    private ServicoBuscaEntrega servicoCrudEntrega;

    @Transactional
    public Ocorrencia gerar(Long entregaId, String descricao) {
        Entrega entrega = servicoCrudEntrega.buscaId(entregaId);
        
        return entrega.adicionarOcorrencia(descricao);
    }
}
