package br.com.gabrieldeoliveira.msr.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gabrieldeoliveira.msr.domain.exceptions.ArgumentoInvalidoExcecao;
import br.com.gabrieldeoliveira.msr.domain.exceptions.EntidadeNaoEncontradaExcecao;
import br.com.gabrieldeoliveira.msr.domain.models.Cliente;
import br.com.gabrieldeoliveira.msr.domain.repositories.RepositorioCliente;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoCrudCliente {

    private RepositorioCliente repositorioCliente;

    @Transactional
    public Cliente salvar(Cliente novo) {
        return repositorioCliente.save(novo);
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarTodos() {
        return repositorioCliente.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return repositorioCliente.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaExcecao(
            String.format("Cliente com Id = %d não encontrado", id)
        ));
    }

    public Cliente idValido(Long clienteId) {
        try {
            return buscarPorId(clienteId);
        } catch (RuntimeException e) {
            throw new ArgumentoInvalidoExcecao(
                String.format("Cliente com Id = %d não encontrado", clienteId)
            );
        }
    }

    @Transactional
    public Cliente atualizar(Long clienteId, Cliente dadosNovos) {
        Cliente cliente = buscarPorId(clienteId);

        // Atualiza-se nome, email e telefone se vier os dados.
        atualizarCom(cliente, dadosNovos);
        return repositorioCliente.save(cliente);
    }

    @Transactional
    public void removerId(Long id) {
        buscarPorId(id);
        repositorioCliente.deleteById(id);
    }

    private void atualizarCom(Cliente cliente, Cliente dadosNovos) {
        final String nome = dadosNovos.getNome();
        final String email = dadosNovos.getEmail();
        final String telefone = dadosNovos.getTelefone();
        if (nome != null && nome != "") {
            cliente.setNome(nome);
        }
        if (email != null && email != "") {
            cliente.setEmail(email);
        }
        if (telefone != null && telefone != "") {
            cliente.setTelefone(telefone);
        }
    }
}
