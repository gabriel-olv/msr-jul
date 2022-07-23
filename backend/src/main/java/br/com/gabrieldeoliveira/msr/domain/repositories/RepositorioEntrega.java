package br.com.gabrieldeoliveira.msr.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.msr.domain.models.Entrega;

public interface RepositorioEntrega extends JpaRepository<Entrega, Long> {
    
}
