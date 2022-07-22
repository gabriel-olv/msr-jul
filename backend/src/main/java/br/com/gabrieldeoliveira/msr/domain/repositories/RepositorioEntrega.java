package br.com.gabrieldeoliveira.msr.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.msr.domain.model.Entrega;

public interface RepositorioEntrega extends JpaRepository<Entrega, Long> {
    
}
