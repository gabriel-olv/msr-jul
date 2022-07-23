package br.com.gabrieldeoliveira.msr.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.repositories.RepositorioEntrega;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoBuscaEntrega {

    private RepositorioEntrega repositorioEntrega;

    @Transactional(readOnly = true)
    public List<Entrega> todasEntregas() {
        return repositorioEntrega.findAll();
    }

    @Transactional(readOnly = true)
    public Entrega buscaId(Long id) {
        return repositorioEntrega.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Entrega com Id = %d não encontrada", id)));
    }
}
