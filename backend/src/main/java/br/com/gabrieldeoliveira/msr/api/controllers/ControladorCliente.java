package br.com.gabrieldeoliveira.msr.api.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrieldeoliveira.msr.api.models.cliente.ClienteDeEntrada;
import br.com.gabrieldeoliveira.msr.api.models.cliente.ClienteDeEntradaAtualizacao;
import br.com.gabrieldeoliveira.msr.api.models.cliente.ClienteResumo;
import br.com.gabrieldeoliveira.msr.api.transporters.TransportadorCliente;
import br.com.gabrieldeoliveira.msr.domain.models.Cliente;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoCrudCliente;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ControladorCliente {

    private ServicoCrudCliente servicoCrudCliente;

    private TransportadorCliente transportadorCliente;

    @GetMapping
    public ResponseEntity<List<ClienteResumo>> listar() {
        List<Cliente> clientes = servicoCrudCliente.listarTodos();
        return ResponseEntity.ok(transportadorCliente.paraListModeloResumo(clientes));
    }

    @PostMapping
    public ResponseEntity<ClienteResumo> salvar(@RequestBody @Valid ClienteDeEntrada dto) {
        Cliente cliente = transportadorCliente.paraEntidade(dto);
        cliente = servicoCrudCliente.salvar(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(transportadorCliente.paraModeloResumo(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResumo> buscarId(@PathVariable Long id) {
        Cliente cliente = servicoCrudCliente.buscarPorId(id);

        return ResponseEntity.ok(transportadorCliente.paraModeloResumo(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable(name = "id") Long clienteId,
            @RequestBody @Valid ClienteDeEntradaAtualizacao dto) {
        Cliente dadosNovos = transportadorCliente.paraEntidade(dto);
        dadosNovos = servicoCrudCliente.atualizar(clienteId, dadosNovos);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerId(@PathVariable Long id) {
        servicoCrudCliente.removerId(id);

        return ResponseEntity.noContent().build();
    }
}
