package br.com.gabrieldeoliveira.msr.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrieldeoliveira.msr.domain.models.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
    
}
