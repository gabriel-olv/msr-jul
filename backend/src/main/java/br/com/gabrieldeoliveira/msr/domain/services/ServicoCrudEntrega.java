package br.com.gabrieldeoliveira.msr.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.repositories.RepositorioEntrega;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoCrudEntrega {

    private RepositorioEntrega repositorioEntrega;

    @Transactional
    public Entrega salvar(Entrega entrega) {
        return repositorioEntrega.save(entrega);
    }

    public Entrega buscaId(Long id) {
        return repositorioEntrega.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Entrega com Id = %d não encontrada", id)));
    }
}
